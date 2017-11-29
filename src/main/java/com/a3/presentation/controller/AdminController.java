package com.a3.presentation.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a3.application.models.Employee;
import com.a3.service.EmployeeService;

@Controller
public class AdminController {
	@Autowired
	EmployeeService emplS;

	@RequestMapping("/admin")
	public String hallo(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("employeeList", emplS.getAllEmployees());
		return "admin";
	}

	@RequestMapping(value = "admin.get", method = RequestMethod.GET, params = { "employeePNC", "action" })
	public String search(@RequestParam("employeePNC") long employeePNC, @RequestParam("action") String action,
			BindingResult result, Map<String, Object> map) {
		switch (action.toLowerCase()) {
		case "search":
			Employee searcherdEmployee = emplS.getEmployeeByPNC(employeePNC);

			if (searcherdEmployee != null) {
				List<Employee> list = new ArrayList<Employee>();
				list.add(searcherdEmployee);
				map.put("employeeList", list);
				break;
			} else {
				map.put("employeeList", emplS.getAllEmployees());
				break;
			}
		case "show all":
			map.put("showEdit", "false");
			map.put("employeeList", emplS.getAllEmployees());
			break;
		}
		Employee empl = new Employee();
		map.put("employee", empl);
		return "admin";
	}

	@RequestMapping(value = "admin.action", method = RequestMethod.POST)
	public String doActions(@ModelAttribute("employee") Employee employee, BindingResult result,
			@RequestParam String action, Map<String, Object> map) {
		switch (action.toLowerCase()) {
		case "delete":
			emplS.delete(employee);
			break;
		}
		map.put("employeeList", emplS.getAllEmployees());
		Employee empl = new Employee();
		map.put("employee", empl);

		return "admin";
	}

	@RequestMapping(value = "admin/update", method = RequestMethod.GET, params = { "employeePNC" })
	public String upd(@RequestParam("employeePNC") long employeePNC, Map<String, Object> map) {
		map.put("employee", emplS.getEmployeeByPNC(employeePNC));
		return "admin/update";
	}

	@RequestMapping(value = "admin/update.upd", method = RequestMethod.POST)
	public String doupd(@ModelAttribute("employee") Employee employee, Map<String, Object> map) {
		emplS.edit(employee);
		return "redirect:../admin";
	}

	@RequestMapping(value = "admin/add")
	public String add(Map<String, Object> map) {
		map.put("employee", new Employee());
		return "admin/add";
	}

	@RequestMapping(value = "admin/add.add", method = RequestMethod.POST)
	public String doadd(@ModelAttribute("employee") Employee employee, Map<String, Object> map) {
		emplS.add(employee);
		return "redirect:../admin";
	}
}
