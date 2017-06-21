package com.kbank.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.dao.VisitPathDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.model.VisitPathMst;

@Service("visitPathSevice")
public class VisitPathServiceImpl implements VisitPathService {

	@Autowired
	@Qualifier("visitPathDao")
	VisitPathDao visitPathDao;
	
	@Autowired
	@Qualifier("corporationDao")
	CorporationDao corporationDao;
	
	private static final Logger logger = Logger.getLogger(VisitPathServiceImpl.class);
	
	@Override
	public DataTable<VisitPathMst> searchVisitPath(SearchDataTable<VisitPathMst> searchDataTable) {
		DataTable<VisitPathMst> result = new DataTable<>();
		try {
			List<VisitPathMst> visits = visitPathDao.searchVisitPath(searchDataTable);
			result.setData(visits);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(visitPathDao.countVisitPathTotal(searchDataTable));
			result.setRecordsFiltered(visitPathDao.countVisitPathFilter(searchDataTable));
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public List<VisitPathMst> getVisitPathDetail(int accountId, String type) {
		List<VisitPathMst> result = null;
		try {
			result = visitPathDao.getVisitPathDetail(accountId, type);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public CorporationMst getCorporationNameForVisitPath(String corpCode) {
		CorporationMst result = null;
		try {
			result = corporationDao.getCorporationMstByCorpCode(corpCode);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

}
