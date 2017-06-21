package com.kbank.lms.dao;

import java.util.List;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.ClientMst;

public interface ClientDao {

	public void insertClientMst(ClientMst clientMst);
	public int checkClientDuplicate(String clientCode);
	public ClientMst getClientByClientCodeTmp(String clientCode);
	public ClientMst getClientByClientMst(String clientCode);
	public void insertClientTmp(ClientMst clientMst);
	public void copyToClientMst(ClientMst clientMst);
	public void copyToClientTmp(ClientMst clientMst);
	public void copyToClientTmpDelete(ClientMst clientMst);
	public void updateAutorizeStatus(ClientMst clientMst);
	public void deleteClientMstClientCode(String clientCode);
	public void deleteClientTmpClientCode(String clientCode);
	public void updateClientTmpToClientMst(ClientMst clientMst);
	public void updateClientTmp(ClientMst clientMst);
	public int countClientFilter(SearchDataTable<ClientMst> searchDataTable);
	public List<ClientMst> searchClient(SearchDataTable<ClientMst> searchDataTable);
	public int countClientTotal(SearchDataTable<ClientMst> searchDataTable);
	public int countClientMst();
	public int countClientTmp();
	public void deleteAllClientTmp();
	public void deleteAllClientMst();
	public String getCisByClientCode(String clientCode);
}
