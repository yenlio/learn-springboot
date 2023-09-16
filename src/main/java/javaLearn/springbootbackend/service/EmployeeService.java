package javaLearn.springbootbackend.service;

import javaLearn.springbootbackend.model.Employee;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeService {
    List<Employee> searchEmployees(String  query);
    Page<Employee> findEmployeeWithPagination(int offset, int pageSize);
    List<Employee> getAllEmployeesSortedByFirstName(int offset, int pageSize,String sortBy);

}
