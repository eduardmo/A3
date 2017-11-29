package com.a3.data.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a3.application.models.Employee;
import com.a3.data.dao.EmployeeDAO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessF;
	@Override
	public void add(Employee employee) {
		sessF.getCurrentSession().save(employee);
	}
	@Override
	public void edit(Employee employee) {
		if(employee.getPassword().equals("")){
		Employee empl = sessF.getCurrentSession().get(Employee.class, employee.getEmployeePNC());
		employee.setPassword(empl.getPassword());
		}
		sessF.getCurrentSession().merge(employee);
	}

	@Override
	public Employee getEmployeeByPNC(long employeePNC) {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Employee.class);
		crit.add(Restrictions.like("employeePNC", employeePNC));
		crit.add(Restrictions.not(Restrictions.like("role", "ROLE_ADMIN")));
		return (Employee) crit.uniqueResult();
	}

	@Override
	public void delete(Employee employee) {
		sessF.getCurrentSession().delete(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Employee.class);
		crit.add(Restrictions.not(Restrictions.like("role", "ROLE_ADMIN")));
		List<Employee> list = (List<Employee>)crit.list();
		
		return list;
	}

	@Override
	public Employee getEmployeeByUserName(String username) {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit= sessF.getCurrentSession().createCriteria(Employee.class);
		crit.add(Restrictions.not(Restrictions.like("role", "ROLE_ADMIN")));
		crit.add(Restrictions.eq("username",username));
		return (Employee) crit.uniqueResult();
	}
	@Override
	public List<Employee> getAllDoctors() {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Employee.class);
		List<Employee> list = (List<Employee>)crit.add(Restrictions.like("role", "ROLE_DOCTOR")).list();
		System.out.println(list.size());
		return list;
	}


}
