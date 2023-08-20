package javaLearn.springbootbackend.repository;

import javaLearn.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//Employee: kiểu của thực thể
//Long is typeOf PrimaryKey
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 //all crud Db methods

}
