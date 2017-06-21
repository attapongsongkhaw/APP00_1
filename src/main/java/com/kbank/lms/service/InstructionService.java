package com.kbank.lms.service;

import java.util.List;

import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.InstructionMst;

public interface InstructionService {
	
	public void saveInstructionByMaker(InstructionMst instructionMst, String mode, String type);
	public void acceptInstructionByInstructionId(InstructionMst instructionMst);
	public int checkInstructionDuplicate(int instructionId);
	public DataTable<InstructionMst> searchInstruction(SearchDataTable<InstructionMst> searchDataTable);
	public List<InstructionMst> getInstructionPendingByInstructionId(int instructionId);
	public List<InstructionMst> getInstructionActiveByInstructionId(int instructionId);
	public void deleteInstructionByInstructionId(InstructionMst instructionMst);
	public void cancelInstructionByInstructionId(int instructionId);
	public void rejectInstructionByInstructionId(InstructionMst instructionMst);
	public List<InstructionMst> getInstructionByCorpCode(String corpCode);
	public List<InstructionMst> getInstructionMstByCorpCode(String corpCode);
}
