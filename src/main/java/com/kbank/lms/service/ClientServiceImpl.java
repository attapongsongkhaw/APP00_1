package com.kbank.lms.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.dao.ClientDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.ClientMst;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	@Qualifier("clientDao")
	private ClientDao clientDao;
	
	private static final Logger logger = Logger.getLogger(ClientServiceImpl.class);
	
	@Override
	public void saveClientByMaker(ClientMst clientMst, String mode, String type){
		try {
			//clientMst.setAuthorizeStatus("W");
			if("ADD".equals(mode)){
				clientMst.setOperationFlag("N");
				clientDao.insertClientTmp(clientMst);
			}else if("EDIT".equals(mode)){
				if("A".equals(type)){
					clientMst.setOperationFlag("E");
					clientDao.copyToClientTmp(clientMst);
				}else if("P".equals(type)){
					clientDao.updateClientTmp(clientMst);
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void acceptClientByClientCode(ClientMst clientMst){
		try {
			if("D".equals(clientMst.getOperationFlag())){
				clientDao.deleteClientMstClientCode(clientMst.getClientCode());
				clientDao.deleteClientTmpClientCode(clientMst.getClientCode());
			}else{
				clientMst.setAuthorizeStatus("Y");
				ClientMst client = clientDao.getClientByClientMst(clientMst.getClientCode());
				if(client == null){
					clientDao.copyToClientMst(clientMst);
					clientDao.deleteClientTmpClientCode(clientMst.getClientCode());
				}else{ 
					ClientMst clientMst2 = clientDao.getClientByClientCodeTmp(clientMst.getClientCode());
					if(clientMst2 != null){
						clientMst2.setAuthorizedBy(clientMst.getAuthorizedBy());
						clientMst2.setAuthorizedDate(clientMst.getAuthorizedDate());
						clientMst2.setAuthorizeStatus(clientMst.getAuthorizeStatus());
						clientDao.updateClientTmpToClientMst(clientMst2);
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public int checkClientDuplicate(String clientCode) {
		int result = 0;
		try {
			result = clientDao.checkClientDuplicate(clientCode);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
	
	@Override
	public DataTable<ClientMst> searchClient(SearchDataTable<ClientMst> searchDataTable) {
		DataTable<ClientMst> result = new DataTable<>();
		try {
			List<ClientMst> clients = clientDao.searchClient(searchDataTable);
			result.setData(clients);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(clientDao.countClientTotal(searchDataTable));
			result.setRecordsFiltered(clientDao.countClientFilter(searchDataTable));
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public ClientMst getClientPendingByClientCode(String clientCode) {
		ClientMst result = null;
		try {
			result = clientDao.getClientByClientCodeTmp(clientCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
	
	@Override
	public ClientMst getClientActiveByClientCode(String clientCode) {
		ClientMst result = null;
		try {
			result = clientDao.getClientByClientMst(clientCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public void deleteClientByClientCode(ClientMst clientMst) {
		try {
			clientDao.copyToClientTmpDelete(clientMst);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}

	@Override
	public void cancelClientByClientCode(String clientCode) {
		try {
			clientDao.deleteClientTmpClientCode(clientCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}

	@Override
	public void rejectClientByClientCode(ClientMst clientMst) {
		try {
			clientDao.updateAutorizeStatus(clientMst);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}

	@Override
	public String getCisByClientCode(String clientCode) {
		String result = null;
		try {
			result = clientDao.getCisByClientCode(clientCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
}
