package com.aya.repository;

import com.aya.entity.Course;
import com.aya.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
   // List<Course> findByCategoryAndOrderByName(String category); --- wont work AND is not applicable
    List<Course> findByCategoryOrderByName(String category);

    //check if a course with provided name exists. return true if the course exists, false otherwise
    boolean existsByName(String name);

    //return the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course> findByNameStartingWith(String pattern);

    //find all courses by category and returns a stream
//    @Modifying
//    @Transactional
    Stream<Course> streamByCategory(String category);


    @Query("SELECT c FROM Course c WHERE c.category=:category and c.rating>:rating")
    List<Employee> findAllByCategoryAndRating(@Param("category") String category, @Param("rating") int rating);







}
