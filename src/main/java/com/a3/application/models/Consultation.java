package com.a3.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Consultation {
	@Id
	@Column
	private int consultationID;
	@Column
	private String consultationDate;
	@Column
	private String consultationTime;
	@Column
	private String consultationDetails;
	@Column
	private long clientPNC;
	@Column
	private long employeePNC;
	@Column
	private String consultationStatus;
	
	public int getConsultationID() {
		return consultationID;
	}

	public void setConsultationID(int consultationID) {
		this.consultationID = consultationID;
	}

	public String getConsultationTime() {
		return consultationTime;
	}

	public void setConsultationTime(String consultationTime) {
		this.consultationTime = consultationTime;
	}

	public String getConsultationDetails() {
		return consultationDetails;
	}

	public void setConsultationDetails(String consultationDetails) {
		this.consultationDetails = consultationDetails;
	}

	public String getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(String consultationDate) {
		this.consultationDate = consultationDate;
	}

	public long getClientPNC() {
		return clientPNC;
	}

	public void setClientPNC(long clientPNC) {
		this.clientPNC = clientPNC;
	}

	public String getConsultationStatus() {
		return consultationStatus;
	}

	public void setConsultationStatus(String consultationStatus) {
		this.consultationStatus = consultationStatus;
	}

	public long getEmployeePNC() {
		return employeePNC;
	}

	public void setEmployeePNC(long employeePNC) {
		this.employeePNC = employeePNC;
	}

}
