package com.kbank.lms.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.kbank.lms.dao.FunctionDao;
import com.kbank.lms.dao.InstructionDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.FunctionMst;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	@Qualifier("functionDao")
	private FunctionDao functionDao;
	
	@Autowired
	private InstructionDao instructionDao;
	
	private static final Logger logger = Logger.getLogger(FunctionServiceImpl.class);
	
	@Override
	public void saveFunctionByMaker(FunctionMst functionMst, String mode, String type) {
		try {
			//functionMst.setAuthorizeStatus("W");
			if("ADD".equals(mode)){
				functionMst.setOperationFlag("N");
				if(functionMst.getFuncCode() != null && !"".equals(functionMst.getFuncCode())){
					String[] funcCodes = functionMst.getFuncCode().split(",");
					for(int i = 0; i < funcCodes.length; i++) {
						functionMst.setFuncCode(funcCodes[i]);
						functionDao.insertFunctionTmp(functionMst);
					}
				}
			}else if("EDIT".equals(mode)){
				if("A".equals(type)){
					FunctionMst funcMst2 = functionDao.getFunctionMstByCorpCode(functionMst.getCorpCode());
					functionMst.setCreatedBy(funcMst2.getCreatedBy());
					functionMst.setCreatedDate(funcMst2.getCreatedDate());
					functionMst.setSyncDate(funcMst2.getSyncDate());
					functionMst.setSyncStatus(funcMst2.getSyncStatus());
					functionMst.setSyncMessage(funcMst2.getSyncMessage());
					functionMst.setOperationFlag("E");
					if(functionMst.getFuncCode() != null && !"".equals(functionMst.getFuncCode())){
						String[] funcCodes = functionMst.getFuncCode().split(",");
						for(int i = 0; i < funcCodes.length; i++) {
							functionMst.setFuncCode(funcCodes[i]);
							functionDao.insertFunctionTmp(functionMst);
						}
					}
				}else if("P".equals(type)){
					FunctionMst funcMst2 = functionDao.getFunctionTmpByCorpCode(functionMst.getCorpCode());
					functionMst.setCreatedBy(funcMst2.getCreatedBy());
					functionMst.setCreatedDate(funcMst2.getCreatedDate());
					functionMst.setSyncDate(funcMst2.getSyncDate());
					functionMst.setSyncStatus(funcMst2.getSyncStatus());
					functionMst.setSyncMessage(funcMst2.getSyncMessage());
					functionMst.setOperationFlag(funcMst2.getOperationFlag());
					functionDao.updateFunctionTmp(functionMst);
					
					/*functionDao.deleteFunctionTmpCorpCode(functionMst.getCorpCode());
					if(functionMst.getFuncCode() != null && !"".equals(functionMst.getFuncCode())){
						String[] funcCodes = functionMst.getFuncCode().split(",");
						for(int i = 0; i < funcCodes.length; i++) {
							functionMst.setFuncCode(funcCodes[i]);
							functionDao.insertFunctionTmp(functionMst);
						}
					}*/
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void acceptFunctionByCorpCode(FunctionMst functionMst) {
		try {
			functionDao.updateAutorizeStatus(functionMst);
			functionDao.updateEffectiveDate(functionMst.getCorpCode());
			instructionDao.deleteInstructionTmpByCorpCodeAndOperationFlag(functionMst.getCorpCode(), "D");
			instructionDao.updateAutorizeStatusByCorpCode(functionMst.getCorpCode(), functionMst.getAuthorizeStatus(), functionMst.getAuthorizedBy(), functionMst.getRejectReason());
		}catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
	}
	
	@Override
	public int checkFunctionDuplicate(String corpCode) {
		int result = 0;
		try {
			result = functionDao.checkFunctionDuplicate(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public DataTable<FunctionMst> searchFunction(SearchDataTable<FunctionMst> searchDataTable) {
		DataTable<FunctionMst> result = new DataTable<>();
		try {
			List<FunctionMst> functions = functionDao.searchFunction(searchDataTable);
			result.setData(functions);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(functionDao.countFunctionTotal(searchDataTable));
			result.setRecordsFiltered(functionDao.countFunctionFilter(searchDataTable));
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public FunctionMst getFunctionPendingByCorpCode(String corpCode) {
		FunctionMst result = null;
		try {
			result = functionDao.getFunctionTmpByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public FunctionMst getFunctionActiveByCorpCode(String corpCode) {
		FunctionMst result = null;
		try {
			result = functionDao.getFunctionMstByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
 
	@Override
	public void deleteFunctionByCorpCode(FunctionMst functionMst) {
		try {
			functionDao.copyToFunctionTmpDelete(functionMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public void cancelFunctionByCorpCode(String corpCode) {
		try {
			functionDao.deleteFunctionTmpCorpCode(corpCode);
			instructionDao.deleteInstructionTmpByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public void rejectFunctionByCorpCode(FunctionMst functionMst) {
		try {
			functionDao.updateAutorizeStatus(functionMst);
			instructionDao.updateAutorizeStatusByCorpCode(functionMst.getCorpCode(), functionMst.getAuthorizeStatus(), functionMst.getAuthorizedBy(), functionMst.getRejectReason());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
}
