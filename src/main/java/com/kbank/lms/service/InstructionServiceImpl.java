package com.kbank.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kbank.lms.dao.InstructionDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.InstructionMst;

@Service("instructionService")
public class InstructionServiceImpl implements InstructionService {

	@Autowired
	private InstructionDao instructionDao;
	
	private static final Logger logger = Logger.getLogger(InstructionServiceImpl.class);

	@Override
	public void saveInstructionByMaker(InstructionMst instructionMst, String mode, String type) {
		try {
			if("ADD".equals(mode)){
				instructionDao.insertInstructionTmp(instructionMst);
			}else if("EDIT".equals(mode)){
				if(type.equals("A")){
					if(instructionMst.getInstructionId() == 0) {
						instructionDao.insertInstructionTmp(instructionMst);
					} else {
						List<InstructionMst> instruction2 = instructionDao.getInstructionMstByInstructionId(instructionMst.getInstructionId());
						InstructionMst instrucMst = instruction2.get(0);
						instructionMst.setCreatedBy(instrucMst.getCreatedBy());
						instructionMst.setCreatedDate(instrucMst.getCreatedDate());
						//instructionMst.setSyncDate(instrucMst.getSyncDate());
						//instructionMst.setSyncStatus(instrucMst.getSyncStatus());
						//instructionMst.setSyncMessage(instrucMst.getSyncMessage());
						instructionDao.insertInstructionTmp(instructionMst);
					}
				}else if("P".equals(type)){
					if(instructionDao.countInstructionTmpByInstructionId(instructionMst.getInstructionId()) == 0) {
						instructionDao.insertInstructionTmp(instructionMst);
					} else {
						instructionDao.updateInstructionTmp(instructionMst);
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void acceptInstructionByInstructionId(InstructionMst instructionMst) {
		try {
			instructionDao.updateAutorizeStatus(instructionMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public int checkInstructionDuplicate(int instructionId) {
		int result = 0;
		try {
			result = instructionDao.checkInstructionDuplicate(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public DataTable<InstructionMst> searchInstruction(SearchDataTable<InstructionMst> searchDataTable) {
		DataTable<InstructionMst> result = new DataTable<>();
		try {
			List<InstructionMst> instructions = instructionDao.searchInstruction(searchDataTable);
			result.setData(instructions);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(instructionDao.countInstructionTotal(searchDataTable));
			result.setRecordsFiltered(instructionDao.countInstructionFilter(searchDataTable));
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> getInstructionPendingByInstructionId(int instructionId) {
		List<InstructionMst> result = null;
		try {
			result = instructionDao.getInstructionTmpByInstructionId(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> getInstructionActiveByInstructionId(int instructionId) {
		List<InstructionMst> result = null;
		try {
			result = instructionDao.getInstructionMstByInstructionId(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public void deleteInstructionByInstructionId(InstructionMst instructionMst) {
		try {
			 instructionDao.copyToInstructionTmpDelete(instructionMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void cancelInstructionByInstructionId(int instructionId) {
		try {
			 instructionDao.deleteInstructionTmpInstructionId(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public void rejectInstructionByInstructionId(InstructionMst instructionMst) {
		try {
			instructionDao.updateAutorizeStatus(instructionMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public List<InstructionMst> getInstructionByCorpCode(String corpCode) {
		List<InstructionMst> result = null;
		try {
			result = instructionDao.getInstructionByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> getInstructionMstByCorpCode(String corpCode) {
		List<InstructionMst> result = null;
		try {
			result = instructionDao.getInstructionMstByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
}
