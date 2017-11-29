package com.a3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a3.application.models.Consultation;
import com.a3.data.dao.ConsultationDAO;
import com.a3.service.ConsultationService;

@Service
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	ConsultationDAO consD;
	
	@Transactional
	public void add(Consultation cons) {
		consD.add(cons);
	}

	@Transactional
	public void edit(Consultation cons) {
		consD.edit(cons);
	}

	@Transactional
	public Consultation getConsultationByID(int consultationID) {
		return consD.getConsultationByID(consultationID);
	}

	@Transactional
	public void delete(Consultation cons) {
		consD.delete(cons);
	}

	@Transactional
	public List<Consultation> getAllConsultations() {
		return consD.getAllConsultations();
	}

	@Transactional
	public List<Consultation> getClientConsultations(long clientID) {
		return consD.getConsultationsByClient(clientID);
	}
	@Transactional
	public List<Consultation> getDoctorConsultations(long doctorID) {
		return consD.getConsultationsByDoctor(doctorID);
	}
}
