
package com.a3.data.dao;

import java.util.List;

import com.a3.application.models.Client;

public interface ClientDAO {
	public void add(Client client);
	public void edit(Client client);
	public Client getClientByPNC(long clientPNC);
	public void delete(Client client);
	public List<Client> getAllClients();
}
