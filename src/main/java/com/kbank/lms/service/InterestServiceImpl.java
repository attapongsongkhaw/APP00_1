package com.kbank.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.dao.InterestDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.InterestMst;

@Service("interestService")
public class InterestServiceImpl implements InterestService {

	@Autowired
	@Qualifier("interestDao")
	InterestDao interestDao;
	
	private static final Logger logger = Logger.getLogger(InterestServiceImpl.class);
	
	@Override
	public DataTable<InterestMst> searchInterest(SearchDataTable<InterestMst> searchDataTable) {
		DataTable<InterestMst> result = new DataTable<>();
		try {
			List<InterestMst> interests = interestDao.searchInterest(searchDataTable);
			result.setData(interests);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(interestDao.countInterestTotal(searchDataTable));
			result.setRecordsFiltered(interestDao.countInterestFilter(searchDataTable));
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public void saveInterestByMaker(InterestMst interestMst, String mode, String type) {
		try {
			interestMst.setAuthorizeStatus("W");
			if("ADD".equals(mode)){
				interestMst.setOperationFlag("N");
				interestDao.insertInterestTmp(interestMst);
			}else if("EDIT".equals(mode)){
				if("A".equals(type)){
					interestMst.setOperationFlag("E");
					interestDao.copyToInterestTmp(interestMst);
				}else if("P".equals(type)){
					interestDao.updateInterestTmp(interestMst);
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}

	@Override
	public int checkInterestDuplicate(InterestMst interestMst) throws Exception {
		int result = 0;
		try {
			result = interestDao.checkInterestDuplicate(interestMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
	
	@Override
	public InterestMst getInterestPending(InterestMst interestMst) {
		InterestMst result = null;
		try {
			result = interestDao.getInterestTmp(interestMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public InterestMst getInterestActive(InterestMst interestMst) {
		InterestMst result = null;
		try {
			result = interestDao.getInterestMst(interestMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
}
