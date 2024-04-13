package com.aya.repository;

import com.aya.entity.Department;
import com.aya.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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





}
