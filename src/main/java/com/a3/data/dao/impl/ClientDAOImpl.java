package com.a3.data.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a3.application.models.Client;
import com.a3.data.dao.ClientDAO;

@Repository
public class ClientDAOImpl implements ClientDAO {
	@Autowired
	private SessionFactory sessF;
	
	@Override
	public void add(Client client) {
		sessF.getCurrentSession().save(client);
	}

	@Override
	public void edit(Client client) {
		sessF.getCurrentSession().update(client);
	}

	@Override
	public Client getClientByPNC(long clientPNC) {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Client.class);
		crit.add(Restrictions.like("clientPNC", clientPNC));
		return (Client) crit.uniqueResult();
	}

	@Override
	public void delete(Client client) {
		sessF.getCurrentSession().delete(client);
	}

	@Override
	public List<Client> getAllClients() {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Client.class);
		List<Client> list = crit.list();
		return list;
	}

}
