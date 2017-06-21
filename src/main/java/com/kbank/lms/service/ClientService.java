package com.kbank.lms.service;

import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.ClientMst;

public interface ClientService {

	public void saveClientByMaker(ClientMst clientMst, String mode, String type);
	public int checkClientDuplicate(String clientCode);
	public DataTable<ClientMst> searchClient(SearchDataTable<ClientMst> searchDataTable);
	public ClientMst getClientPendingByClientCode(String clientCode);
	public ClientMst getClientActiveByClientCode(String clientCode);
	public void deleteClientByClientCode(ClientMst clientMst);
	public void cancelClientByClientCode(String clientCode);
	public void acceptClientByClientCode(ClientMst clientMst);
	public void rejectClientByClientCode(ClientMst clientMst);
	public String getCisByClientCode(String clientCode);
}
