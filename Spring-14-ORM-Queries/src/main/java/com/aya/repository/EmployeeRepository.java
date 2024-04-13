package com.aya.repository;

import com.aya.entity.Department;
import com.aya.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //display all employees with email address ""
    List<Employee> findByEmail(String email);

    //display all employees with first name ' ' and last name ' ', also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName,String email);

    //display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);


    //display all employees where last name starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);


  //display all employees with salary higher than ''
    List<Employee> findBySalaryIsGreaterThan(Integer salary);

    //display all employees with salary less than ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //display all employees with salary higher than '' in desc order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);


    //display top unique employees that making less than ''
    List<Employee> findDistinctTop3BySalaryIsLessThan(Integer salary);

    //display all employees that do not have email address ""
    List<Employee> findByEmailIsNull();


    @Query("SELECT e FROM Employee e WHERE e.email='eseakin3b@tmall.com'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='eseakin3b@tmall.com'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeDetail(String email, Integer salary);


    //not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary<?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary>?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //before
    @Query("SELECT e FROM Employee e WHERE e.hireDate>?1 ")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);


    //between
    @Query("SELECT e FROM Employee e WHERE e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //null
    @Query("SELECT e FROM Employee e WHERE e.email is null")
    List<Employee> getEmployeeEmailIsNull();

    //not null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNotNull();

    //sorting ascending
    @Query("SELECT e FROM Employee e ORDER BY e.salary asc ")
    List<Employee> getEmployeeSalaryOrderAsc();

    //sorting descending
    @Query("SELECT e FROM Employee e ORDER BY e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDesc();

//=============================Native query=============================================================

  @Query(value = "SELECT * FROM employees where salary=?1", nativeQuery = true)
  List<Employee> readEmployeeDetailBySalary(int salary);


//=============================Name binding parameter=============================================================

  @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
  List<Employee> getEmployeeSalary(@Param("salary") int salary);



  @Modifying
  @Transactional
  @Query("UPDATE Employee e set e.email='admin@gmail.com' where e.id=:id")
  void updateEmployeeJPQL(@Param("id") Long id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE employees set email='admin@gmail.com' where id=:id", nativeQuery = true)
  void updateEmployeeNativeQuery(@Param("id") Long id);









}
