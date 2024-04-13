package com.aya.bootstrap;

import com.aya.entity.Employee;
import com.aya.repository.CourseRepository;
import com.aya.repository.DepartmentRepository;
import com.aya.repository.EmployeeRepository;
import com.aya.repository.RegionRepository;
import jakarta.persistence.Column;
import org.hibernate.cache.spi.RegionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataGenerator implements CommandLineRunner {


    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;


    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        System.out.println("===============================REGION START============================");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));

        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("United States"));


        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));

        System.out.println("findByCountryContainingOrderBOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));

        System.out.println("findByCountryContainingOrderBOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("United"));

        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("===============================REGION END============================");

        System.out.println("===============================DEPARTMENT START============================");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findByDivisionEquals: " + departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("===============================DEPARTMENT END============================");

        System.out.println("===============================EMPLOYEE START============================");
        System.out.println("findByEmail: " + employeeRepository.findByEmail("amcnee1@google.es"));
        System.out.println("findByFirstNameAndLastNameOrEmail: " + employeeRepository.findByFirstNameAndLastNameOrEmail("Alyson","Franzonello","any@gmail.com"));
//        System.out.println("findByFirstNameIsNot: " + employeeRepository.findByFirstNameIsNot("Alyson"));
        System.out.println("findByLastNameStartingWith: " + employeeRepository.findByLastNameStartingWith("Fr"));
//        System.out.println("findBySalaryIsGreaterThan: " + employeeRepository.findBySalaryIsGreaterThan(100000));
//        System.out.println("findBySalaryLessThanEqual: " + employeeRepository.findBySalaryLessThanEqual(90000));
        System.out.println("findByHireDateBetween: " + employeeRepository.findByHireDateBetween(LocalDate.parse("2005-12-02"),LocalDate.parse("2007-11-28")));
//        System.out.println("findBySalaryIsGreaterThanEqualOrderBySalaryDesc: " + employeeRepository.findBySalaryIsGreaterThanEqualOrderBySalaryDesc(100000));
        System.out.println("findDistinctTop3BySalaryIsLessThan: " + employeeRepository.findDistinctTop3BySalaryIsLessThan(90000));
//        System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());

        System.out.println("===============================EMPLOYEE END============================");

        System.out.println("===============================EMPLOYEE JPQL START============================");
        System.out.println("getEmployeeDetail:  " + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary:  " + employeeRepository.getEmployeeSalary());

        System.out.println("===============================EMPLOYEE JPQL END============================");

        System.out.println("===============================COURSE START============================");
        System.out.println("findByCategory:  " + courseRepository.findByCategory("Java"));

        courseRepository.findByCategory("Java").forEach(System.out::println);

      //  System.out.println("findByCategoryAndOrderByName:  " + courseRepository.findByCategoryAndOrderByName("Java"));
        System.out.println("findByCategoryOrderByName:  " + courseRepository.findByCategoryOrderByName("Java"));
        System.out.println("existsByName:  " + courseRepository.existsByName("JavaScript"));
        System.out.println("countByCategory:  " + courseRepository.countByCategory("Java"));
        System.out.println("countByCategory:  " + courseRepository.countByCategory("Spring"));
        System.out.println("findByNameStartingWith:  " + courseRepository.findByNameStartingWith("Rapid"));

        courseRepository.streamByCategory("Java").forEach(System.out::println);
        System.out.println("streamByCategory:  " + courseRepository.streamByCategory("Java").collect(Collectors.toList()));

        System.out.println("===============================COURSE END============================");

    }
}
