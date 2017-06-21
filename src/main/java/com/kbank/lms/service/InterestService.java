package com.kbank.lms.service;

import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.InterestMst;

public interface InterestService {

	public DataTable<InterestMst> searchInterest(SearchDataTable<InterestMst> searchDataTable);
	public void saveInterestByMaker(InterestMst interestMst, String mode, String type);
	public int checkInterestDuplicate(InterestMst interestMst) throws Exception;
	public InterestMst getInterestActive(InterestMst interestMst);
	public InterestMst getInterestPending(InterestMst interestMst);
}
