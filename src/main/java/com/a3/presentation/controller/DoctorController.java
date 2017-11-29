package com.a3.presentation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a3.application.models.Client;
import com.a3.application.models.Consultation;
import com.a3.service.ClientService;
import com.a3.service.ConsultationService;
import com.a3.service.EmployeeService;

@Controller
public class DoctorController {
	@Autowired
	ConsultationService consS;
	@Autowired
	EmployeeService emplS;
	@Autowired
	ClientService clientS;

	@RequestMapping("/doctor")
	public String doctor(Map<String, Object> map) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		long crtDoc = emplS.getEmployeeByUserName(username).getEmployeePNC();
		map.put("consl", consS.getDoctorConsultations(crtDoc));
		map.put("ser", clientS);
		map.put("client", new Client());
		map.put("consultation", new Consultation());
		return "doctor";
	}

	@RequestMapping(value = "doctor.get", method = RequestMethod.GET, params = { "clientPNC", "action" })
	public String search(@RequestParam("clientPNC") long clientPNC, @RequestParam("action") String action,
			@ModelAttribute("client") Client client, BindingResult result, Map<String, Object> map) {
		switch(action.toLowerCase()){
		case "show all previous consultations":
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = user.getUsername();
			long crtDoc = emplS.getEmployeeByUserName(username).getEmployeePNC();
			map.put("consl", consS.getDoctorConsultations(crtDoc));
			map.put("ser", clientS);
			map.put("client", new Client());
			map.put("consultation", new Consultation());
			break;
		case "show patient previous consultations":
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			username = user.getUsername();
			crtDoc = emplS.getEmployeeByUserName(username).getEmployeePNC();
			if(!consS.getClientConsultations(clientPNC).isEmpty())
				map.put("consl", consS.getClientConsultations(clientPNC));
			else
				map.put("consl", consS.getDoctorConsultations(crtDoc));
				map.put("ser", clientS);
				map.put("client", new Client());
				map.put("consultation", new Consultation());
			break;
		}
				
		return "doctor";
	}
	
	@RequestMapping(value = "doctor/update", method = RequestMethod.GET, params = { "consultationID" })
	public String upd(@RequestParam("consultationID") int consultationID, Map<String, Object> map) {
		map.put("consultation", consS.getConsultationByID(consultationID));
		return "doctor/update";
	}
	
	@RequestMapping(value = "doctor.acc", method = RequestMethod.POST)
	public String doctadd(@ModelAttribute("consultation") Consultation cons, Map<String, Object> map) {
		System.out.println(cons.getConsultationID());
		Consultation c = consS.getConsultationByID(cons.getConsultationID());
		c.setConsultationStatus("ADDED");
		consS.edit(c);
		map.put("consultation", c);
		return "redirect:doctor";
	}
	
	@RequestMapping(value = "doctor/update.upd", method = RequestMethod.POST)
	public String doupd(@ModelAttribute("consultation") Consultation cons, Map<String, Object> map) {
		consS.edit(cons);
		return "redirect:../doctor";
	}
}
