package javaLearn.springbootbackend.repository;

import javaLearn.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Employee: kiểu của thực thể
//Long is typeOf PrimaryKey
public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
 //all crud Db methods
    @Query(value = "SELECT e from Employee e WHERE " +
            "e.firstName LIKE  CONCAT('%' ,:query,'%')" +
            "OR e.lastName LIKE  CONCAT('%' ,:query,'%')")
    List<Employee> searchEmployee(String query);


}
