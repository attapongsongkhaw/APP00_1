package com.kbank.lms.soap.ws.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.CompanyProfileBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.DeleteCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.DeleteCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.ModifyCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.ModifyCompanyResBase;
import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.soap.ws.entity.WsCompanyResult;
import com.kbank.lms.soap.ws.entity.WsCorporationTemp;
import com.kbank.lms.soap.ws.entity.WsCompanyResult.DefinedResult;

@Service("corporationManagementService")
public class CorporationManagementService {
	private static final Logger LOGGER = Logger.getLogger(CorporationManagementService.class);
	private static final int MAX_CORP_NAME = 255;
	private static final String SOAP_USER = "UMM";
	private static final String AUTHORIZE_STATUS_DRAFT = "D";
	private static final String OPERATIONFLAG_N = "N";
	private static final String DELETE= "DELETE";
	private static final String ADD= "ADD";
	private static final String MODIFY = "MODIFY";
	private static final String ACTIVE = "A";
	private static final String INACTIVE = "I";
	private static final String ENABLED = "ENABLED";

	@Autowired
	@Qualifier("corporationDao") 
	private CorporationDao corporationDao;
	
	
	private CorporationManagementService(){ }

	public CreateCompanyResBase createCompany(CreateCompanyReqBase input) {

		CompanyProfileBase xmlCompany ;
		DefinedResult messageError = null;
		Timestamp ummRequestDate = new java.sql.Timestamp(new Date().getTime());

		if ((input != null) && (input.getCompanyProfile() != null)) {
			xmlCompany = input.getCompanyProfile();
			LOGGER.info(" >>> Create Company :"+toString(xmlCompany));

			if(input.getUMMHeader()!=null){
				ummRequestDate = DataUtil.convertStringToTimestampDate(input.getUMMHeader().getRequestDate());
			}	


			try {
				WsCorporationTemp corpTemp = this.convertXmlCompanyToCorparaionModel(xmlCompany,ADD);
				messageError  = this.validateCreateCorparation(corpTemp) ;
				if(messageError == null){
					corpTemp.setUmmSyncDate(ummRequestDate);
					LOGGER.info("==== create corp (New Corp) ");
					LOGGER.info(" createCompany getCorpCode:"+ corpTemp.getCorpCode());
					LOGGER.info(" createCompany getCorpName:"+  corpTemp.getCorpName());
					LOGGER.info(" createCompany getAuthorizeStatus:"+  corpTemp.getAuthorizeStatus());
					LOGGER.info(" createCompany getActiveStatus:"+  corpTemp.getActiveStatus());
					LOGGER.info(" createCompany getOperationFlag:"+  corpTemp.getOperationFlag());
					LOGGER.info(" createCompany getCreatedBy:"+  corpTemp.getCreatedBy());
					LOGGER.info(" createCompany getLastUpdatedBy:"+  corpTemp.getLastUpdatedBy());
					LOGGER.info(" createCompany ummCompanyStatus:"+  corpTemp.getUmmCompanyStatus());
					LOGGER.info(" createCompany ummServiceStatus:"+  corpTemp.getUmmServiceStatus());
					LOGGER.info(" createCompany ummSyncDate:"+  corpTemp.getUmmSyncDate());
					corporationDao.insertCorporationTmp(corpTemp); 
					messageError = DefinedResult.SUCCESS; 
				}else if(DefinedResult.ERROR_COMPANY_EXIST.equals(messageError)){
					corpTemp.setUmmSyncDate(ummRequestDate);
					LOGGER.info("==== create corp (Existing Corp) ");
					LOGGER.info(" createCompany getCorpCode:"+ corpTemp.getCorpCode());
					LOGGER.info(" createCompany getCorpName:"+  corpTemp.getCorpName());
					LOGGER.info(" createCompany getLastUpdatedBy:"+  corpTemp.getLastUpdatedBy());
					LOGGER.info(" createCompany ummCompanyStatus:"+  corpTemp.getUmmCompanyStatus());
					LOGGER.info(" createCompany ummServiceStatus:"+  corpTemp.getUmmServiceStatus());
					LOGGER.info(" createCompany ummSyncDate:"+  corpTemp.getUmmSyncDate());
					corporationDao.updateCorporationInformationWithUMMProfile(corpTemp);
					messageError = DefinedResult.SUCCESS; 
				}

				LOGGER.info("Create Company : " + corpTemp);
			}catch(Exception xe){
				LOGGER.error("createCompany Exception : " + xe);
				messageError = DefinedResult.ERROR_CREATE_COMP_FAIL;
				return generateCreateCompanyResponse(new WsCompanyResult(messageError));
			}
		} 
		if(null == messageError){
		    messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER ; 
		}

		LOGGER.info("Create Company : result = " + messageError);
		return generateCreateCompanyResponse(new WsCompanyResult(messageError));
	}


	public ModifyCompanyResBase modifyCompany(ModifyCompanyReqBase input) {
		CompanyProfileBase xmlCompany ;
		DefinedResult messageError  = null;
		Timestamp ummRequestDate = new java.sql.Timestamp(new Date().getTime());

		if ((input != null) && (input.getCompanyProfile() != null)) {
			xmlCompany = input.getCompanyProfile();
			LOGGER.info(" >>> modifyCompany :"+toString(xmlCompany));
			if(input.getUMMHeader()!=null){
				ummRequestDate = DataUtil.convertStringToTimestampDate(input.getUMMHeader().getRequestDate());
			}

			try {
				WsCorporationTemp corpTemp = this.convertXmlCompanyToCorparaionModel(xmlCompany,MODIFY);

				messageError  = this.validateModifyCorparation(corpTemp) ;
				if(messageError == null){
					corpTemp.setUmmSyncDate(ummRequestDate);
					LOGGER.info(" modifyCompany getCorpCode:"+ corpTemp.getCorpCode());
					LOGGER.info(" modifyCompany getCorpName:"+  corpTemp.getCorpName());
					LOGGER.info(" modifyCompany ummCompanyStatus:"+  corpTemp.getUmmCompanyStatus());
					LOGGER.info(" modifyCompany ummServiceStatus:"+  corpTemp.getUmmServiceStatus());
					LOGGER.info(" modifyCompany ummSyncDate:"+  corpTemp.getUmmSyncDate());
					corporationDao.updateCorporationInformationWithUMMProfile(corpTemp);
					messageError = DefinedResult.SUCCESS; 
				}

			}catch(Exception xe){
				LOGGER.error("modifyCompany Exception : " + xe);
				messageError = DefinedResult.ERROR_EDIT_COMP_FAIL;
				return generateModifyCompanyResponse(new WsCompanyResult(messageError));
			}
		}         


		if(null == messageError){
			messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER ; 
		}

		LOGGER.info("Modify Company : result = " + messageError);
		return generateModifyCompanyResponse(new WsCompanyResult(messageError));
	}

	/**
	 * 
	 * @param input
	 * @return returns
	 *         com.kbank.corp.umm.schema.companymanagement.DeleteCompanyResBase
	 */
	public DeleteCompanyResBase deleteCompany(DeleteCompanyReqBase input) {
		CompanyProfileBase xmlCompany ;
		String companyCode;
		DefinedResult messageError = null ;
		Timestamp ummRequestDate;

		if ((input != null) && (input.getCompanyProfile() != null)) {
			companyCode = input.getCompanyProfile().getCompanyCode();
			xmlCompany = input.getCompanyProfile();
			LOGGER.info(" >>> deleteCompany :"+toString(xmlCompany));

			if(input.getUMMHeader()!=null){
				ummRequestDate = DataUtil.convertStringToTimestampDate(input.getUMMHeader().getRequestDate());
			}else{
				ummRequestDate = new java.sql.Timestamp(new Date().getTime());
			}

			messageError = this.validateDeleteCorparation(companyCode);
			if(null == messageError ){
				try{
					WsCorporationTemp corpTemp = this.convertXmlCompanyToCorparaionModel(xmlCompany,DELETE);
					corpTemp.setUmmSyncDate(ummRequestDate);
					LOGGER.info(" deleteCompany getCorpCode:"+ corpTemp.getCorpCode());
					LOGGER.info(" deleteCompany ummCompanyStatus:"+  corpTemp.getUmmCompanyStatus());
					LOGGER.info(" deleteCompany ummServiceStatus:"+  corpTemp.getUmmServiceStatus());
					LOGGER.info(" deleteCompany ummSyncDate:"+  corpTemp.getUmmSyncDate());
					corporationDao.updateCorporationUMMStatusOnlyWithUMMProfile(corpTemp);
					messageError = DefinedResult.SUCCESS ;
				}catch(Exception xe){
					LOGGER.error(" deleteCompany Exception : " + xe);
					messageError = DefinedResult.ERROR_CANT_DELETE;
					return generateDeleteCompanyResponse(new WsCompanyResult(messageError));
				}

			}
		}
		
		
		if(null == messageError){
		    messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER ; 
		}


		return generateDeleteCompanyResponse(new WsCompanyResult(messageError));
	}

	/**
	 * 
	 * @param input
	 * @return returns
	 *         com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyResBase
	 */
	public CheckDeleteCompanyResBase checkDeleteCompany(CheckDeleteCompanyReqBase input) {

		String companyCode;
		DefinedResult messageError = null;

		if (input != null) {
			companyCode = input.getCompanyCode();
			messageError = this.validateDeleteCorparation(companyCode);
			if(null == messageError){
				messageError = DefinedResult.SUCCESS ;
			}	

		}	
		
		if(null == messageError){
		    messageError = DefinedResult.ERROR_INVALID_INPUT_PARAMETER ; 
		}
		/** return true all case */
		return generateCheckDeleteCompanyResponse(new WsCompanyResult(messageError));
	}

	private DefinedResult validateCreateCorparation(WsCorporationTemp corpTemp){
		LOGGER.info(" <<<<<<<<<<<<<<<<<<  VALIDATION create corparation >>>>>>>>>>>> ");
		String corpCode ;
		String corpName ;


		if(corpTemp == null){
			LOGGER.info(" validateCreateCorparation : Corparation object is null ");
			return DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
		}else {
			corpCode = corpTemp.getCorpCode();
			corpName = corpTemp.getCorpName();

			if(DataUtil.isEmptyOrNull(corpCode) ||  DataUtil.isEmptyOrNull(corpName) ){
				LOGGER.info(" validateCreateCorparation : Corparation not fond mandatory ");
				return DefinedResult.ERROR_FIELD_CHECK_FAIL;
			}else if(corporationDao.checkCorpDuplicate(corpCode) > 0 ){
				LOGGER.info("validateCreateCorparation : ERROR_COMPANY_EXIST ");
				return DefinedResult.ERROR_COMPANY_EXIST;

			}else{
				LOGGER.info("validateCreateCorparation : <<<<<  null >>>> ");
				return null;
			}
		}

	}


	private DefinedResult validateModifyCorparation(WsCorporationTemp corpTemp){
		LOGGER.info(" <<<<<<<<<<<<<<<<<<  VALIDATION modify corparation >>>>>>>>>>>> ");

		String corpName ;
		String corpCode ;

		if( null == corpTemp ){
			LOGGER.info(" validateModifyCorparation : Corparation object is null ");
			return DefinedResult.ERROR_INVALID_INPUT_PARAMETER;
		}else{
			corpCode = corpTemp.getCorpCode();
			corpName = corpTemp.getCorpName();

			if(DataUtil.isEmptyOrNull(corpCode) ||  DataUtil.isEmptyOrNull(corpName) ){
				LOGGER.info(" validateModifyCorparation : Corparation not fond mandatory ");
				return DefinedResult.ERROR_FIELD_CHECK_FAIL;
			}else if(0 == corporationDao.checkCorpDuplicate(corpCode)){
				LOGGER.info(" validateModifyCorparation : ERROR_COMPANY_NOT_FOUND ");
				return DefinedResult.ERROR_COMPANY_NOT_FOUND;
			}else{
				return null;
			}
		}

	}

	private DefinedResult validateDeleteCorparation(String corpCode){
		LOGGER.info(" <<<<<<<<<<<<<<<<<<  VALIDATION modify corparation >>>>>>>>>>>> ");

		if(DataUtil.isEmptyOrNull(corpCode) ){
			LOGGER.info(" validateDeleteCorparation : Corparation not fond mandatory ");
			return DefinedResult.ERROR_FIELD_CHECK_FAIL;
		}else if(0 == corporationDao.checkCorpDuplicate(corpCode)){
			LOGGER.info(" validateDeleteCorparation : ERROR_COMPANY_NOT_FOUND ");
			return DefinedResult.ERROR_COMPANY_NOT_FOUND;
		}else{
			LOGGER.info(" validateDeleteCorparation : <<<<<  null >>>> ");
			return null;
		}

	}

	private String getUmmServiceStatus(com.kbank.corp.umm.schema.ummcommon.Services services){
		String serviceStatusTemp = "" ;
		String serviceStatus = INACTIVE;
		if(services != null  && services.getService()!=null && services.getService().size() > 0 ){
			List<com.kbank.corp.umm.schema.ummcommon.Service> umm = services.getService();
			com.kbank.corp.umm.schema.ummcommon.Service service = umm.get(0);

			if(service!=null ){
				serviceStatusTemp = service.getServiceStatus();
				LOGGER.info("========  Get Service ===============");
				LOGGER.info("getServiceCode:"+service.getServiceCode());
				LOGGER.info("getServiceStartdate:"+service.getServiceStartdate());
				LOGGER.info("getServiceEnddate:"+service.getServiceEnddate());
				LOGGER.info("getServiceName:"+service.getServiceName());
				LOGGER.info("getServiceStatus:"+service.getServiceStatus());
				LOGGER.info("========  End  Get Service ===============");
			}


			if("A".equals(serviceStatusTemp) || ENABLED.equals(serviceStatusTemp)){
				serviceStatus = ACTIVE;
			}else{
				serviceStatus = INACTIVE;
			}
		}	

		return serviceStatus;
	}
	private WsCorporationTemp convertXmlCompanyToCorparaionModel(CompanyProfileBase xmlCompany ,String action) {
		LOGGER.info("");
		LOGGER.info("+++++++++++++++++++  convertXmlCompanyToCorparaionModel +++++++++++++++++++  action : "+action);
		WsCorporationTemp corpTemp = null;
		String companyName ;
		String companyStatus = INACTIVE;
		String companyStatusTemp ;
		String serviceStatus  ;
		String companyNameEng ;
		if (xmlCompany != null) {
			corpTemp = new WsCorporationTemp();
			companyStatusTemp = xmlCompany.getCompanyStatus();
			/**
			 *   UMM company status  
			 *         A - Active
			 *         I - Inactive 
			 **/
			if(!DataUtil.isEmptyOrNull(companyStatusTemp) ){
				companyStatus = "A".equals(companyStatusTemp)?ACTIVE:INACTIVE ;
			}

			serviceStatus = this.getUmmServiceStatus(xmlCompany.getCompanyServices());


			companyNameEng = xmlCompany.getCompanyNameEn();
			if(!DataUtil.isEmptyOrNull(companyNameEng)){
				companyName = companyNameEng.length()<=MAX_CORP_NAME?companyNameEng:companyNameEng.substring(0, MAX_CORP_NAME);
				corpTemp.setCorpName(companyName);
			}

			corpTemp.setCorpCode(xmlCompany.getCompanyCode());
			corpTemp.setLastUpdatedBy(SOAP_USER);
			corpTemp.setUmmCompanyStatus(INACTIVE);
			corpTemp.setUmmServiceStatus(INACTIVE);


			if(ADD.equals(action)){
				corpTemp.setActiveStatus("Y");
				corpTemp.setCreatedBy(SOAP_USER);
				corpTemp.setAuthorizeStatus(AUTHORIZE_STATUS_DRAFT);
				corpTemp.setOperationFlag(OPERATIONFLAG_N);
				corpTemp.setUmmCompanyStatus(companyStatus);
				corpTemp.setUmmServiceStatus(serviceStatus);

			}else if(MODIFY.equals(action)){

				corpTemp.setUmmCompanyStatus(companyStatus);
				corpTemp.setUmmServiceStatus(serviceStatus);

			}else if (DELETE.equals(action)){
				corpTemp.setUmmCompanyStatus(companyStatus);
				corpTemp.setUmmServiceStatus(INACTIVE);
			}

			/** parent company */
			corpTemp.setCorparationParentCode("ParentTmp");
		}



		return corpTemp;
	}


	private static String toString(CompanyProfileBase xmlCompany) {
		StringBuilder sb = new StringBuilder(" : \r\n");
		sb.append(xmlCompany.toString());
		return sb.toString();
	}

	private static CreateCompanyResBase generateCreateCompanyResponse( WsCompanyResult result) {
		CreateCompanyResBase response = new CreateCompanyResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}

	private static ModifyCompanyResBase generateModifyCompanyResponse( WsCompanyResult result) {
		ModifyCompanyResBase response = new ModifyCompanyResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}

	private static DeleteCompanyResBase generateDeleteCompanyResponse( WsCompanyResult result) {
		DeleteCompanyResBase response = new DeleteCompanyResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}

	private static CheckDeleteCompanyResBase generateCheckDeleteCompanyResponse( WsCompanyResult result) {
		CheckDeleteCompanyResBase response = new CheckDeleteCompanyResBase();
		response.setResponseDate(DataUtil.toDateTimeFormat(new Date()));
		if (result != null) {
			response.setSuccess(result.isSuccess());
			response.setCode(result.getCode());
			response.setMessage(result.getMessage());
		}
		return response;
	}
	public void clearCorporationByCorpCode(String corpCode){
		corporationDao.deleteCorporationMstCorpCode(corpCode);
		corporationDao.deleteCorporationTmpCorpCode(corpCode);
	}

}
