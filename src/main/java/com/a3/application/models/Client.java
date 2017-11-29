package com.a3.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	@Id
	@Column
	@NotNull
	private long clientPNC;
	@Column
	private String clientName;
	@Column
	private String clientIDCard;
	@Column
	private String birthdate;
	@Column
	private String address;

	public long getClientPNC() {
		return clientPNC;
	}

	public void setClientPNC(long clientPNC) {
		this.clientPNC = clientPNC;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientIDCard() {
		return clientIDCard;
	}

	public void setClientIDCard(String clientIDCard) {
		this.clientIDCard = clientIDCard;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
