package com.kbank.lms.service;

import java.util.List;

import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.model.VisitPathMst;

public interface VisitPathService {

	public DataTable<VisitPathMst> searchVisitPath(SearchDataTable<VisitPathMst> searchDataTable);
	public List<VisitPathMst> getVisitPathDetail(int accountId, String type);
	public CorporationMst getCorporationNameForVisitPath(String corpCode);
}
