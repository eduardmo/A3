package com.a3.presentation.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.a3.application.models.Client;
import com.a3.application.models.Consultation;
import com.a3.application.models.Employee;
import com.a3.service.ClientService;
import com.a3.service.ConsultationService;
import com.a3.service.EmployeeService;

@Controller
public class ClientController {
	@Autowired
	ClientService clientS;
	@Autowired
	ConsultationService consS;

	@Autowired
	EmployeeService emplS;

	static Client updClient = new Client();

	@RequestMapping("/secretary")
	public String hallo(Map<String, Object> map) {
		map.put("client", new Client());
		map.put("clientList", clientS.getAllClients());
		return "secretary";
	}

	@RequestMapping(value = "secretary.get", method = RequestMethod.GET, params = { "clientPNC", "action" })
	public String search(@RequestParam("clientPNC") long clientPNC, @RequestParam("action") String action,
			@ModelAttribute("client") Client client, BindingResult result, Map<String, Object> map) {
		switch (action.toLowerCase()) {
		case "search":
			Client searcherdClient = clientS.getClientByPNC(clientPNC);

			if (searcherdClient != null) {
				List<Client> list = new ArrayList<Client>();
				list.add(searcherdClient);
				map.put("clientList", list);
				break;
			} else {
				System.out.println("ceva acolo fix aici1");
				map.put("showEdit", "false");
				map.put("message", "Employee not found");
				map.put("clientList", clientS.getAllClients());
				break;
			}
		case "show all":
			map.put("showEdit", "false");
			map.put("clientList", clientS.getAllClients());
			break;
		}
		Client clientRes = new Client();
		map.put("client", clientRes);
		return "secretary";
	}

	@RequestMapping(value = "secretary.action", method = RequestMethod.POST)
	public String doActions(@ModelAttribute("client") Client client, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		switch (action.toLowerCase()) {
		case "delete":
			clientS.delete(client);
			break;
		case "notify":
			Consultation cons = new Consultation();
			cons.setClientPNC(client.getClientPNC());
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal = Calendar.getInstance();
			cons.setConsultationDate(dateFormat.format(cal.getTime()));
			dateFormat = new SimpleDateFormat("HH:mm");
			cal = Calendar.getInstance();
			cons.setConsultationTime(dateFormat.format(cal.getTime()));
			cons.setConsultationStatus("SET");
			cons.setConsultationDetails("");
			cons.setEmployeePNC(emplS.getAllDoctors().get(0).getEmployeePNC());
			consS.add(cons);
			break;
		}
		map.put("clientList", clientS.getAllClients());
		Client clientRes = new Client();
		map.put("client", clientRes);
		
		return "secretary";
	}

	@RequestMapping(value = "secretary/update", method = RequestMethod.GET, params = { "clientPNC" })
	public String upd(@RequestParam("clientPNC") long clientPNC, Map<String, Object> map) {
		map.put("client", clientS.getClientByPNC(clientPNC));
		return "secretary/update";
	}

	@RequestMapping(value = "secretary/update.upd", method = RequestMethod.POST)
	public String doupd(@ModelAttribute("client") Client client, Map<String, Object> map) {
		clientS.edit(client);
		return "redirect:../secretary";
	}

	@RequestMapping(value = "secretary/add")
	public String add(Map<String, Object> map) {
		map.put("client", new Client());
		return "secretary/add";
	}

	@RequestMapping(value = "secretary/add.add", method = RequestMethod.POST)
	public String doadd(@ModelAttribute("client") Client client, Map<String, Object> map) {
		System.out.println(client.getClientPNC());
		clientS.add(client);
		return "redirect:../secretary";
	}

	@RequestMapping(value = "secretary/consultation", method = RequestMethod.GET, params = { "clientPNC" })
	public String cons(@RequestParam("clientPNC") long clientPNC, Map<String, Object> map) {
		map.put("consultation", new Consultation());
		map.put("clientPNC", clientPNC);
		map.put("employee", emplS.getAllDoctors());
		map.put("consList", consS.getClientConsultations(clientPNC));
		return "secretary/consultation";
	}

	@RequestMapping(value = "secretary/consultation.add", method = RequestMethod.POST)
	public String consadd(@ModelAttribute("consultation") Consultation consultation, Map<String, Object> map) {
		consultation.setConsultationDetails("");
		consultation.setConsultationStatus("SET");
		consS.add(consultation);
		map.put("consultation", new Consultation());
		map.put("clientPNC", consultation.getClientPNC());
		map.put("employee", emplS.getAllDoctors());
		map.put("consList", consS.getClientConsultations(consultation.getClientPNC()));
		return "secretary/consultation";
	}

	@RequestMapping(value = "secretary/consultation.delete", method = RequestMethod.POST)
	public String consdelete(@ModelAttribute("consultation") Consultation consultation, Map<String, Object> map) {
		long client = consultation.getClientPNC();
		System.out.println(consultation.getClientPNC() + "aici");
		consS.delete(consultation);
		System.out.println(client + "aici");		
		map.put("consultation", new Consultation());
		map.put("clientPNC", client);
		map.put("employee", emplS.getAllDoctors());
		map.put("consList", consS.getClientConsultations(client));
		return "secretary/consultation";
	}
	
	
	
	@RequestMapping(value = {"/check"}, method = RequestMethod.GET)
	public @ResponseBody List<String> check(Map<String, Object> map) {
		List<String> datal = new ArrayList<String>();
		String data1="";
		String data2="";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		long crtDoc = emplS.getEmployeeByUserName(username).getEmployeePNC();
		List<Consultation> consl = consS.getAllConsultations();
		System.out.println(consl.size());
		for(Consultation cons:consl){
			if(cons.getConsultationStatus().contains("SET") && cons.getEmployeePNC() == crtDoc){
				data1 = "Patient " + clientS.getClientByPNC(cons.getClientPNC()).getClientName() + " is waiting!";
				data2 += cons.getConsultationID();
			}
		}
		datal.add(data1);
		datal.add(data2);
		
		return datal;
	}
}
