package com.a3.service;

import java.util.List;

import com.a3.application.models.Client;

public interface ClientService {
	public void add(Client client);
	public void edit(Client client);
	public Client getClientByPNC(long clientPNC);
	public void delete(Client client);
	public List<Client> getAllClients();
}
