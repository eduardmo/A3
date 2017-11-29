package hibernatetest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.a3.application.models.Employee;
import com.a3.data.dao.EmployeeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet.xml" })
@TransactionConfiguration
@Transactional
public class EmployeeTest {

	@Autowired
	EmployeeDAO emplD;

	@Test
	public void testAdd() {
		Employee employee = new Employee();
		employee.setEmployeeName("Test 1");
		employee.setEmployeePNC(9876543210000l);
		employee.setUsername("test");
		employee.setPassword("test");
		employee.setRole("ROLE_SECRETARY");
		emplD.add(employee);
		Assert.assertEquals(employee, emplD.getEmployeeByPNC(9876543210000l));
	}

	@Test
	public void testEdit() {
		Employee employee = new Employee();
		employee.setEmployeeName("Test 1");
		employee.setEmployeePNC(9876543210000l);
		employee.setUsername("test");
		employee.setPassword("test");
		employee.setRole("ROLE_SECRETARY");
		emplD.add(employee);
		employee.setUsername("test1");
		emplD.edit(employee);
		Assert.assertEquals(employee, emplD.getEmployeeByPNC(9876543210000l));

	}

	@Test
	public void testDelete() {
		Employee employee = new Employee();
		employee.setEmployeeName("Test 1");
		employee.setEmployeePNC(9876543210000l);
		employee.setUsername("test");
		employee.setPassword("test");
		employee.setRole("ROLE_SECRETARY");
		emplD.add(employee);
		emplD.delete(employee);
		assertNotEquals(emplD.getEmployeeByPNC(9876543210000l), employee);
	}

}
