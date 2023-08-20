package javaLearn.springbootbackend;

import javaLearn.springbootbackend.model.Employee;
import javaLearn.springbootbackend.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
//	private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee= new Employee();
		employee.setFirstName("Hoang");
		employee.setLastName("Nguyen");
		employee.setEmailId("yen@gmail.com");
		employeeRepository.save(employee);

		Employee employee1= new Employee();
		employee1.setFirstName("Nam");
		employee1.setLastName("Nguyen");
		employee1.setEmailId("nam@gmail.com");
		employeeRepository.save(employee);

	}
}
