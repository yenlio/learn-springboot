package javaLearn.springbootbackend.service.impl;

import javaLearn.springbootbackend.model.Employee;
import javaLearn.springbootbackend.repository.EmployeeRepository;
import javaLearn.springbootbackend.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmloyeeServiceImpl implements EmployeeService {
   private EmployeeRepository employeeRepository;

    public EmloyeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        List<Employee>employees= employeeRepository.searchEmployee(query);
    return employees;
    }
    public Page<Employee> findEmployeeWithPagination(int offset, int pageSize){
        Page<Employee> employees= employeeRepository.findAll(PageRequest.of(offset,pageSize));
        return (Page<Employee>) employees;
    }
    public List<Employee> getAllEmployeesSortedByFirstName(int offset, int pageSize,String sortBy) {

        Sort sort = Sort.by(Sort.Direction.ASC, "lastName");
        Pageable pageable =  PageRequest.of(offset, pageSize, sort);
        Page<Employee> page=employeeRepository.findAll( pageable);
        return page.getContent();
    }

}
