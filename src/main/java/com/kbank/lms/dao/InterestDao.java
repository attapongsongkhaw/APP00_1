package com.kbank.lms.dao;

import java.util.List;

import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.InterestMst;

public interface InterestDao {
	
	public void insertInterestTmp(InterestMst interestMst);
	public void copyToInterestTmp(InterestMst interestMst);
	public List<InterestMst> searchInterest(SearchDataTable<InterestMst> searchDataTable);
	public int countInterestFilter(SearchDataTable<InterestMst> searchDataTable);
	public int countInterestTotal(SearchDataTable<InterestMst> searchDataTable);
	public void updateAutorizeStatus(InterestMst interestMst);
	public void updateInterestTmp(InterestMst interestMst);
	public void copyToInterestMst(InterestMst interestMst);
	public void updateTmpToInterestMst(InterestMst interestMst);
	public int checkInterestDuplicate(InterestMst interestMst) throws Exception;
	public InterestMst getInterestMst(InterestMst interestMst);
	public InterestMst getInterestTmp(InterestMst interestMst);
}
