package javaLearn.springbootbackend.controller;

import javaLearn.springbootbackend.exception.ResourceNotFoundException;
import javaLearn.springbootbackend.model.Employee;
import javaLearn.springbootbackend.model.ResponseObject;
import javaLearn.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
//    dêpndency iecttion
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //get by id
    @GetMapping("{id}")
    // return a object
    public ResponseEntity<ResponseObject> getById(@PathVariable long id){
        //optional ho phép kiểm tra xem liệu có nhân viên nào được tìm thấy hay không.
        Optional<Employee> foundEmployee= employeeRepository.findById(id);
        if(foundEmployee.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","success",foundEmployee)
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "can not found"+id, "")
            );
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateById( @PathVariable long id, @RequestBody Employee employeeDetail){
        Employee updateData= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" NOT FOUND "+id));

        updateData.setFirstName(employeeDetail.getFirstName());
        updateData.setLastName(employeeDetail.getLastName());
        updateData.setEmailId(employeeDetail.getEmailId());
        employeeRepository.save(updateData);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("done", "success", updateData)
        );
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
    Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" not found " + id));

    employeeRepository.delete(employee);
    return ResponseEntity.ok(HttpStatus.PARTIAL_CONTENT);
    }
}
