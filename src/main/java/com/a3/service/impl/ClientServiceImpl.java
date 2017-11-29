package com.a3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a3.application.models.Client;
import com.a3.data.dao.ClientDAO;
import com.a3.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientDAO clientD;
	
	@Transactional
	public void add(Client client) {
		clientD.add(client);
	}

	@Transactional
	public void edit(Client client) {
		clientD.edit(client);
	}

	@Transactional
	public Client getClientByPNC(long clientPNC) {
		return clientD.getClientByPNC(clientPNC);
	}

	@Transactional
	public void delete(Client client) {
		clientD.delete(client);		
	}

	@Transactional
	public List<Client> getAllClients() {
		return clientD.getAllClients();
	}

}
