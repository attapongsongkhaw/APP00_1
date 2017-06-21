package com.kbank.lms.soap.ws.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.corp.umm.schema.ummcommon.UMMRequestBase;
import com.kbank.corp.umm.schema.usermanagement.CheckDeleteUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.CheckDeleteUserResBase;
import com.kbank.corp.umm.schema.usermanagement.CreateUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.CreateUserResBase;
import com.kbank.corp.umm.schema.usermanagement.DeleteUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.DeleteUserResBase;
import com.kbank.corp.umm.schema.usermanagement.ModifyUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.ModifyUserResBase;
import com.kbank.corp.umm.schema.usermanagement.UserProfileBase;
import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.dao.UserDao;
import com.kbank.lms.soap.ws.entity.WsUser;
import com.kbank.lms.soap.ws.entity.WsUserResult;
import com.kbank.lms.soap.ws.entity.WsUserResult.DefinedResult;
import com.kbank.lms.utils.Constants;


@Service("userManagementService")
public class UserManagementService {

	private static final Logger LOGGER= Logger.getLogger(UserManagementService.class);
	private static final String INACTIVE_STATUS = "I";
	private static final String ACTIVE_STATUS = "A";
	private static final String ENABLED = "ENABLED";

	private static final String SOAP_USER = "UMM";

	private static final String ADD= "ADD";
	private static final String DELETE= "DELETE";
	private static final String MODIFY = "MODIFY";

	private static final String COMPANY_USER_GROUP = "CORP"; /** CORP , BANK */
	private static final int DEFAULT_LOCKOUT_COUNTER = 0;
	private static final String DEFAULT_ACTIVE_STATUS = "Y";
	private static final String DEFAULT_LOGGED_ON = "N";
	private static final String AUTHORIZE_STATUS_DRAFT = "D";
	private static final String OPERATIONFLAG_NEW = "N";

	@Autowired
	@Qualifier("userDao") 
	private UserDao userDao;
	
	@Autowired
	@Qualifier("corporationDao") 
	private CorporationDao corporationDao;
	/**
	 * 
	 * @param input
	 * @return returns
	 *         com.kbank.corp.umm.schema.usermanagement.CreateUserResBase
	 */
	private boolean checkMandatoryUser(WsUser wsUser){
		boolean flagFalse = true;

		if(DataUtil.isEmptyOrNull(wsUser.getUserId())){
			return flagFalse;
		}else if(DataUtil.isEmptyOrNull(wsUser.getCorpCode())){
			return flagFalse;
		}else if(DataUtil.isEmptyOrNull(wsUser.getFirstName())){
			return flagFalse;
		}else if(DataUtil.isEmptyOrNull(wsUser.getLastName())){
			return flagFalse;
		}else{
			return true;
		}


	}
	private DefinedResult validateCreateUser(WsUser wsUser){
		LOGGER.info(" <<<<<<<<<<<<<<<<<<  VALIDATION create user >>>>>>>>>>>> ");
		String userLogin;
		String corpCode;


		if(wsUser == null){
			LOGGER.info(" validateCreateUser : user object is null ");
			return DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
		}else {
			userLogin = wsUser.getUserId();
			corpCode = wsUser.getCorpCode();

			if(!this.checkMandatoryUser(wsUser)){
				LOGGER.info(" validateCreateUser : user not fond mandatory ");
				return DefinedResult.ERROR_FIELD_CHECK_FAIL;
			}else if(corporationDao.checkCorpDuplicate(corpCode) == 0 ){
				LOGGER.info("validateCreateUser : ERROR_COMPANY_NOT_EXIST ");
				return DefinedResult.ERROR_COMP_NOT_FOUND;
			}else if(userDao.checkUserDuplicate(userLogin) > 0 ){
				LOGGER.info("validateCreateUser : ERROR_USER_EXIST ");
				return DefinedResult.ERROR_USER_EXIST;

			}else{
				LOGGER.info("validateCreateUser : <<<<<  null >>>> ");
				return null;
			}
		}

	}


	private DefinedResult validateModifyUser(WsUser wsUser){
		LOGGER.info(" <<<<<<<<<<<<<<<<<<  VALIDATION modify User >>>>>>>>>>>> ");

		String userLogin ;

		if( null == wsUser ){
			LOGGER.info(" validateModifyUser : User  object is null ");
			return DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
		}else{
			userLogin = wsUser.getUserId();

			if( !this.checkMandatoryUser(wsUser) ){
				LOGGER.info(" validateModifyUser : user not fond mandatory ");
				return DefinedResult.ERROR_FIELD_CHECK_FAIL;
			}else if(0 == userDao.checkUserDuplicate(userLogin)){
				LOGGER.info(" validateModifyUser : ERROR_USER_NOT_FOUND ");
				return DefinedResult.ERROR_USER_NOT_FOUND;
			}else{
				LOGGER.info("validateModifyUser : <<<<<  null >>>> ");
				return null;
			}
		}

	}

	private DefinedResult validateDeleteUser(String userLogin, String corpCode){
		LOGGER.info(" <<<<<<<<<<<<<<<<<<  VALIDATION modify User >>>>>>>>>>>> ");

		if(DataUtil.isEmptyOrNull(userLogin) ){
			LOGGER.info(" validateDeleteUser : User not fond mandatory ");
			return DefinedResult.ERROR_FIELD_CHECK_FAIL;
		}else if(DataUtil.isEmptyOrNull(corpCode)){
			LOGGER.info(" validateDeleteUser : User not fond mandatory ");
			return DefinedResult.ERROR_FIELD_CHECK_FAIL;
		}else if(0 == userDao.checkUserDuplicate(userLogin)){
			LOGGER.info(" validateDeleteUser : ERROR_COMPANY_NOT_FOUND ");
			return DefinedResult.ERROR_USER_NOT_FOUND;
		}else{
			LOGGER.info(" validateDeleteUser : <<<<<  null >>>> ");
			return null;
		}

	}

	private String getUmmServiceStatus(com.kbank.corp.umm.schema.ummcommon.Services services){
		String serviceStatusTemp = "" ;
		String serviceCode = "";
		String serviceStatus = INACTIVE_STATUS;
		if(services != null  && services.getService()!=null && services.getService().size() > 0 ){
			List<com.kbank.corp.umm.schema.ummcommon.Service> umm = services.getService();
			com.kbank.corp.umm.schema.ummcommon.Service service = umm.get(0);

			if(service!=null ){
				serviceStatusTemp = service.getServiceStatus();
				serviceCode = service.getServiceCode();
				LOGGER.info("========  Get Service ===============");
				LOGGER.info("getServiceCode:"+service.getServiceCode());
				LOGGER.info("getServiceStartdate:"+service.getServiceStartdate());
				LOGGER.info("getServiceEnddate:"+service.getServiceEnddate());
				LOGGER.info("getServiceName:"+service.getServiceName());
				LOGGER.info("getServiceStatus:"+service.getServiceStatus());
				LOGGER.info("========  End  Get Service ===============");
			}


			if("A".equals(serviceStatusTemp) || ENABLED.equals(serviceStatusTemp)){
				serviceStatus = Constants.LMS_SERVICE_CODE.equals(serviceCode)?ACTIVE_STATUS:INACTIVE_STATUS;
			}else{
				serviceStatus = INACTIVE_STATUS;
			}
		}	

		return serviceStatus;
	}
	public CreateUserResBase createUser(CreateUserReqBase input) {

		UserProfileBase xmlUser;
		UMMRequestBase ummHeader;
		DefinedResult messageError = null;
		Timestamp ummRequestDate = new java.sql.Timestamp(new Date().getTime());
		try{

			if ((input != null) && (input.getUserProfile() != null)) {
				xmlUser = input.getUserProfile();
				ummHeader = input.getUMMHeader();
			if(ummHeader != null){
				ummRequestDate = DataUtil.convertStringToTimestampDate(ummHeader.getRequestDate());
			}	
		/**
			if (DataUtil.isEmptyOrNull(xmlUser.getStatus()) ||
					DataUtil.isEmptyOrNull(xmlUser.getCompanyCode()) ||
					DataUtil.isEmptyOrNull(xmlUser.getLoginAccount()) ||	
					DataUtil.isEmptyOrNull(xmlUser.getFirstname()) ||
					DataUtil.isEmptyOrNull(xmlUser.getLastname())) {
				result = new WsUserResult(DefinedResult.ERROR_FIELD_CHECK_FAIL);
				 */
				WsUser user = convertXmlUserToUserMstModel(xmlUser, ADD);
				messageError = this.validateCreateUser(user);
				if(messageError == null){
					user.setUmmSyncDate(ummRequestDate);
					
					LOGGER.info("==== create User (New User ) ");
					LOGGER.info(" create User getCorpCode:"+ user.getCorpCode());
					LOGGER.info(" create User getUserLogin:"+  user.getUserId());
					LOGGER.info(" create User getFirstName:"+  user.getFirstName());
					LOGGER.info(" create User getLastName:"+  user.getLastName());
					LOGGER.info(" create User getActiveStatus:"+  user.getActiveStatus());
					LOGGER.info(" create User getAutorize:"+  user.getAuthorizedBy());
					LOGGER.info(" create User getOperationFlag:"+  user.getOperationFlag());
					LOGGER.info(" create User getCreatedBy:"+  user.getCreatedBy());
					LOGGER.info(" create User getLastUpdatedBy:"+  user.getLastUpdatedBy());
					LOGGER.info(" create User ummUserStatus:"+  user.getUmmUserStatus());
					LOGGER.info(" create User ummServiceStatus:"+  user.getUmmServiceStatus());
					LOGGER.info(" create User ummSyncDate:"+  user.getUmmSyncDate());
					userDao.insertUserTmp(user);
					messageError = DefinedResult.SUCCESS;
				}else if(DefinedResult.ERROR_USER_EXIST.equals(messageError)){
					user.setUmmSyncDate(ummRequestDate);
					userDao.updateUserInformationbyUMM(user);
					messageError = DefinedResult.SUCCESS;
				}

			} else {
				messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
			}


		}catch(Exception xe){
			LOGGER.error("createUser Exception : " + xe);
			messageError = DefinedResult.ERROR_CREATE_USER_FAIL;
			return this.generateCreateUserResponse(new WsUserResult(messageError));
		}

		return this.generateCreateUserResponse(new WsUserResult(messageError));
	}

	/**
	 * 
	 * @param input
	 * @return returns
	 *         com.kbank.corp.umm.schema.usermanagement.ModifyUserResBase
	 */
	public ModifyUserResBase modifyUser(ModifyUserReqBase input) {

		UserProfileBase xmlUser;
		DefinedResult messageError = null;
		UMMRequestBase ummHeader;
		Timestamp ummRequestDate = new java.sql.Timestamp(new Date().getTime());

		try{

		if ((input != null) && (input.getUserProfile() != null)) {
			xmlUser = input.getUserProfile();
			ummHeader = input.getUMMHeader();
			if(ummHeader != null){
				ummRequestDate = DataUtil.convertStringToTimestampDate(ummHeader.getRequestDate());
			}	
			
			
			WsUser user = convertXmlUserToUserMstModel(xmlUser, MODIFY);
			messageError = this.validateModifyUser(user);
			if(messageError == null){
				//
				user.setUmmSyncDate(ummRequestDate);
				userDao.updateUserInformationbyUMM(user);
				//
				messageError = DefinedResult.SUCCESS;
			}

		} else {
			messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
		}

		}catch(Exception xe){
			LOGGER.error("modifyUser Exception : " + xe);
			messageError = DefinedResult.ERROR_EDIT_USER_FAIL;
			return this.generateModifyUserResponse(new WsUserResult(messageError));
		}
		
		return this.generateModifyUserResponse(new WsUserResult(messageError));
	}

	/**
	 * 
	 * @param input
	 * @return returns
	 *         com.kbank.corp.umm.schema.usermanagement.DeleteUserResBase
	 */
	public DeleteUserResBase deleteUser(DeleteUserReqBase input) {
		UserProfileBase xmlUser;
		UMMRequestBase ummHeader;
		Timestamp ummRequestDate = new java.sql.Timestamp(new Date().getTime());

		DefinedResult messageError = null;
		try{
			if ((input != null) && (input.getUserProfile() != null)) {
				xmlUser = input.getUserProfile();
				ummHeader = input.getUMMHeader();
				if(ummHeader != null){
					ummRequestDate = DataUtil.convertStringToTimestampDate(ummHeader.getRequestDate());
				}	
				
				WsUser user = convertXmlUserToUserMstModel(xmlUser, DELETE);
				messageError = this.validateDeleteUser(user.getUserId() , user.getCorpCode());
				if(messageError == null ){
					user.setUmmSyncDate(ummRequestDate);
					userDao.updateUserUMMStatusOnlyWithUMMProfile(user);
					messageError = DefinedResult.SUCCESS;
				}
			} else {
				messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
			}

		}catch(Exception xe){
			LOGGER.error("deleteUser Exception : " + xe);
			messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
			return this.generateDeleteUserResponse(new WsUserResult(messageError));
		}
		return this.generateDeleteUserResponse(new WsUserResult(messageError));
	}

	/**
	 * 
	 * @param input
	 * @return returns
	 *         com.kbank.corp.umm.schema.usermanagement.CheckDeleteUserResBase
	 */
	public CheckDeleteUserResBase checkDeleteUser(CheckDeleteUserReqBase input) {
		String userLogin;
		String corpCode;
		DefinedResult messageError = null;

		try{
			if (input != null) {
				userLogin = input.getLoginAccount();
				corpCode = input.getCompanyCode();

				messageError = this.validateDeleteUser(userLogin, corpCode);
				if(messageError == null){
					messageError = DefinedResult.SUCCESS;
				}

			}else{
				messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
			}

		}catch(Exception xe){
			LOGGER.error("checkDeleteUser Exception : " + xe);
			messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
			return this.generateCheckDeleteUserResponse(new WsUserResult(messageError));
		}
		return this.generateCheckDeleteUserResponse(new WsUserResult(messageError));
	}

	//---------------------------------------------------------------- Mapper


	
	private WsUser convertXmlUserToUserMstModel(UserProfileBase xmlUser, String action) {
		WsUser dbUser = new WsUser();
		String userStatus = INACTIVE_STATUS;
		String userStatusTemp ;
		String serviceStatus ;

		userStatusTemp = xmlUser.getStatus();
			/**
			 *   UMM User status  
			 *         A - Active
			 *         I - Inactive 
			 **/
			if(!DataUtil.isEmptyOrNull(userStatusTemp) ){
				userStatus = ACTIVE_STATUS.equals(userStatusTemp)?ACTIVE_STATUS:INACTIVE_STATUS ;
			}
			
			
			serviceStatus = this.getUmmServiceStatus(xmlUser.getServicelist());

		/** Key value **/
			dbUser.setCorpCode(xmlUser.getCompanyCode());
			dbUser.setUserId(xmlUser.getLoginAccount());

		/** information value **/
			dbUser.setFirstName(xmlUser.getFirstname());
			dbUser.setLastName(xmlUser.getLastname());
			dbUser.setLastUpdatedBy(SOAP_USER);
			dbUser.setUmmUserStatus(userStatus);

			if(ADD.equals(action)){
				dbUser.setCreatedBy(SOAP_USER);
				dbUser.setUserGroup(COMPANY_USER_GROUP);
				dbUser.setLockoutCounter(DEFAULT_LOCKOUT_COUNTER);
				dbUser.setActiveStatus(DEFAULT_ACTIVE_STATUS);
				dbUser.setLoggedOn(DEFAULT_LOGGED_ON);
				dbUser.setAuthorizeStatus(AUTHORIZE_STATUS_DRAFT);
				dbUser.setAuthorizedDate(new Date());
				dbUser.setAuthorizedBy(SOAP_USER);
				dbUser.setOperationFlag(OPERATIONFLAG_NEW);
				dbUser.setUmmServiceStatus(serviceStatus);
				
				
			}else if(MODIFY.equals(action)){
				dbUser.setUmmServiceStatus(serviceStatus);
				
			}else if(DELETE.equals(action)){
				dbUser.setUmmServiceStatus(INACTIVE_STATUS);
				
			}
			
			
			dbUser.setUmmSsoID("TEST");
			
			return dbUser;
	}

	//----------------------------------------------------------------

	private CreateUserResBase generateCreateUserResponse(WsUserResult result) {
		CreateUserResBase response = new CreateUserResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}

	private ModifyUserResBase generateModifyUserResponse(WsUserResult result) {
		ModifyUserResBase response = new ModifyUserResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}

	private DeleteUserResBase generateDeleteUserResponse(WsUserResult result) {
		DeleteUserResBase response = new DeleteUserResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}

	private CheckDeleteUserResBase generateCheckDeleteUserResponse(WsUserResult result) {
		CheckDeleteUserResBase response = new CheckDeleteUserResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}
	
	public void clearAllUserByCorpCode(String corpCode){
		userDao.deleteAllUserTmpByCorpCode(corpCode);
		userDao.deleteAllUserMstByCorpCode(corpCode);
	}

}
