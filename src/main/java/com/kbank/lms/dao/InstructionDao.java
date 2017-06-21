package com.kbank.lms.dao;

import java.util.List;

import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.InstructionMst;

public interface InstructionDao {

	public void insertInstructionMst(InstructionMst instructionMst);
	public int checkInstructionDuplicate(int instructionId);
	public List<InstructionMst> searchInstruction(SearchDataTable<InstructionMst> searchDataTable);
	public void insertInstructionTmp(InstructionMst instructionMst);
	public void copyToInstructionTmp(InstructionMst instructionMst);
	public void updateInstructionTmp(InstructionMst instructionMst);
	public void copyToInstructionTmpDelete(InstructionMst instructionMst);
	public void deleteInstructionMstInstructionId(int instructionId);
	public void deleteInstructionTmpInstructionId(int instructionId);
	public void copyToInstructionMst(InstructionMst instructionMst);
	public List<InstructionMst> getInstructionTmpByInstructionId(int instructionId);
	public List<InstructionMst> getInstructionMstByInstructionId(int instructionId);
	public void updateInstructionTmpToInstructionMst(InstructionMst instructionMst);
	public void updateAutorizeStatus(InstructionMst instructionMst);
	public int countInstructionFilter(SearchDataTable<InstructionMst> searchDataTable);
	public int countInstructionTotal(SearchDataTable<InstructionMst> searchDataTable);
	public List<InstructionMst> getInstructionByCorpCode(String corpCode);
	public List<InstructionMst> getInstructionMstByCorpCode(String corpCode);
	public void updateEffectiveDate(String corpCode);
	public int countInstructionMst();
	public int countInstructionTmp();
	public void deleteAllInstructionTmp();
	public void deleteAllInstructionMst();
	public void deleteInstructionTmpByCorpCode(String corpCode);
	public void updateAutorizeStatusByCorpCode(String corpCode, String authorizeStatus, String authorizeBy, String rejectReason);
	public int countInstructionTmpByInstructionId(int instructionId);
	public void deleteInstructionTmpByCorpCodeAndOperationFlag(String corpCode, String operationFlag);
	
}
