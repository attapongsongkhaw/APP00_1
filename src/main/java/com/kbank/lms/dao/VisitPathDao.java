package com.kbank.lms.dao;

import java.util.List;

import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.VisitPathMst;

public interface VisitPathDao {

	public int countVisitPathFilter(SearchDataTable<VisitPathMst> searchDataTable);
	public List<VisitPathMst> searchVisitPath(SearchDataTable<VisitPathMst> searchDataTable);
	public int countVisitPathTotal(SearchDataTable<VisitPathMst> searchDataTable);
	public List<VisitPathMst> getVisitPathDetail(int accountId, String type);
}
