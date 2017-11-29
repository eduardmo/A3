package com.a3.service;

import java.util.List;

import com.a3.application.models.Consultation;

public interface ConsultationService {
	public void add(Consultation cons);
	public void edit(Consultation cons);
	public Consultation getConsultationByID(int consultationID);
	public void delete(Consultation cons);
	public List<Consultation> getAllConsultations();
	public List<Consultation> getClientConsultations(long clientID);
	public List<Consultation> getDoctorConsultations(long crtDoc);
}
