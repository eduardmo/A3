package com.a3.data.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a3.application.models.Consultation;
import com.a3.data.dao.ConsultationDAO;

@Repository
public class ConsultationDAOImpl implements ConsultationDAO {
	@Autowired
	SessionFactory sessF;

	@Override
	public void add(Consultation cons) {
		sessF.getCurrentSession().save(cons);
	}

	@Override
	public void edit(Consultation cons) {
		sessF.getCurrentSession().update(cons);

	}

	@Override
	public Consultation getConsultationByID(int consultationID) {
		return sessF.getCurrentSession().get(Consultation.class, consultationID);
	}

	@Override
	public void delete(Consultation cons) {
		sessF.getCurrentSession().delete(cons);
	}

	@Override
	public List<Consultation> getAllConsultations() {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Consultation.class);
		List<Consultation> list = (List<Consultation>)crit.list();
		return list;
	}

	@Override
	public List<Consultation> getConsultationsByClient(long clientID) {
		Criteria crit = sessF.getCurrentSession().createCriteria(Consultation.class);
		List<Consultation> list = (List<Consultation>)crit.add(Restrictions.eq("clientPNC",clientID)).list();
		return list;
	}

	@Override
	public List<Consultation> getConsultationsByDoctor(long doctorID) {
		Criteria crit = sessF.getCurrentSession().createCriteria(Consultation.class);
		List<Consultation> list = (List<Consultation>)crit.add(Restrictions.eq("employeePNC",doctorID)).list();
		return list;
	}

}
