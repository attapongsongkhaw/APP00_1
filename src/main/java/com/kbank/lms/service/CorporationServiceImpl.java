package com.kbank.lms.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.dao.AccountDao;
import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.model.ResponseListJson;

@Service("corporationService")
public class CorporationServiceImpl implements CorporationService {

	@Autowired
	@Qualifier("corporationDao")
	private CorporationDao corporationDao;
	
	@Autowired
	@Qualifier("accountDao")
	private AccountDao accountDao;
	
	private static final Logger logger = Logger.getLogger(CorporationServiceImpl.class);
	
	@Override
	public void saveCorporationByMaker(CorporationMst corporationMst, AccountMst savingAccountMst, AccountMst currentAccountMst, String mode, String type) {
		try {
			if(StringUtils.isBlank(corporationMst.getAuthorizeStatus())){
				corporationMst.setAuthorizeStatus("W");
				savingAccountMst.setAuthorizeStatus("W");
				currentAccountMst.setAuthorizeStatus("W");	
			}
			if("ADD".equals(mode)){
				corporationMst.setOperationFlag("N");
				savingAccountMst.setOperationFlag("N");
				currentAccountMst.setOperationFlag("N");
				corporationDao.insertCorporationTmpWithAccount(corporationMst, savingAccountMst, currentAccountMst);
			}else if("EDIT".equals(mode)){
				if("A".equals(type)){
					corporationMst.setOperationFlag("E");
					savingAccountMst.setOperationFlag("E");
					currentAccountMst.setOperationFlag("E");
					corporationMst.setAuthorizeStatus("W");
					savingAccountMst.setAuthorizeStatus("W");
					currentAccountMst.setAuthorizeStatus("W");	
					corporationDao.copyToCorporationTmp(corporationMst, savingAccountMst, currentAccountMst);
				}else if("P".equals(type)){
					corporationMst.setAuthorizeStatus("W");
					savingAccountMst.setAuthorizeStatus("W");
					currentAccountMst.setAuthorizeStatus("W");	
					if("D".equals(corporationMst.getAuthorizeStatus())){
						corporationDao.updateCorporationTmpForDraft(corporationMst, savingAccountMst, currentAccountMst);
					}else{
						corporationDao.updateCorporationTmp(corporationMst, savingAccountMst, currentAccountMst);	
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void acceptCorporationByCorpCode(CorporationMst corporationMst) {
		try {
			if("D".equals(corporationMst.getOperationFlag())){
				corporationDao.deleteCorporationMstCorpCode(corporationMst.getCorpCode());
				corporationDao.deleteCorporationTmpCorpCode(corporationMst.getCorpCode());
			}else{
				corporationMst.setAuthorizeStatus("Y");
				CorporationMst corp = corporationDao.getCorporationMstByCorpCode(corporationMst.getCorpCode());
				if(corp == null){
					corporationDao.copyToCorporationMst(corporationMst);
				}else{
					CorporationMst corpTmp = corporationDao.getCorporationTmpByCorpCode(corporationMst.getCorpCode());
					corporationMst.setLastUpdatedBy(corpTmp.getLastUpdatedBy());
					corporationMst.setLastUpdatedDate(corpTmp.getLastUpdatedDate());
					corporationDao.updateTmpToCorporationMst(corporationMst);
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}

	@Override
	public int checkCorpDuplicate(String corpCode) {
		int result = 0;
		try {
			result = corporationDao.checkCorpDuplicate(corpCode);
		}catch(Exception ex){
			logger.error(ex);
		}
		return result;
	}

	@Override
	public DataTable<CorporationMst> searchCorporation(SearchDataTable<CorporationMst> searchDataTable) {
		DataTable<CorporationMst> result = new DataTable<>();
		try {
			List<CorporationMst> corps = corporationDao.searchCorporation(searchDataTable);
			result.setData(corps);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(corporationDao.countCorporationFilter(searchDataTable));
			result.setRecordsFiltered(corporationDao.countCorporationTotal(searchDataTable));
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public ResponseListJson<CorporationMst, AccountMst>  getCorporationPendingByCorpCode(String corpCode) {
		ResponseListJson<CorporationMst, AccountMst> result = new ResponseListJson<>();
		try {
			CorporationMst corporationMst = corporationDao.getCorporationTmpByCorpCode(corpCode);
			List<AccountMst> accountMsts = accountDao.getAccountTmpByCorpCode(corpCode);
			result.setMaster(corporationMst);
			result.setList(accountMsts);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public ResponseListJson<CorporationMst, AccountMst> getCorporationActiveByCorpCode(String corpCode) {
		ResponseListJson<CorporationMst, AccountMst> result = new ResponseListJson<>();
		try {
			CorporationMst corporationMst = corporationDao.getCorporationMstByCorpCode(corpCode);
			List<AccountMst> accountMsts = accountDao.getAccountMstByCorpCode(corpCode);
			result.setMaster(corporationMst);
			result.setList(accountMsts);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public void deleteCorporationByCorpCode(CorporationMst corporationMst) throws LMSException {
		try {
			if(corporationDao.checkClientInCorporation(corporationMst.getCorpCode()) == 0){
				corporationDao.copyToCorporationTmpDelete(corporationMst);
			}else{
				throw new LMSException(105);
			}
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public void cancelCorporationByCorpCode(String corpCode) {
		try {
			corporationDao.deleteCorporationTmpCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void rejectCorporationByCorpCode(CorporationMst corporationMst) {
		try {
			corporationDao.updateAutorizeStatus(corporationMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
}
