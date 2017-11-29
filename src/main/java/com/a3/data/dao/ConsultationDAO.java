package com.a3.data.dao;

import java.util.List;

import com.a3.application.models.Consultation;

public interface ConsultationDAO {
	public void add(Consultation cons);
	public void edit(Consultation cons);
	public Consultation getConsultationByID(int consultationID);
	public List<Consultation> getConsultationsByClient(long clientID);
	public List<Consultation> getConsultationsByDoctor(long doctorID);
	public void delete(Consultation cons);
	public List<Consultation> getAllConsultations();
}
