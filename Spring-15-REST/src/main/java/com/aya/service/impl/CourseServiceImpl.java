package com.aya.service.impl;

import com.aya.dto.CourseDTO;
import com.aya.entity.Course;
import com.aya.repository.CourseRepository;
import com.aya.service.CourseService;
import com.aya.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourseDTO createCourse(CourseDTO course) {

        courseRepository.save(mapperUtil.convert(course, new Course()));

        return course;
    }

    @Override
    public CourseDTO getCourseById(long courseId) {
        return mapperUtil.convert(courseRepository.findById(courseId),new CourseDTO());
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category).stream()
                .map(course->mapperUtil.convert(course,new CourseDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {

        return courseRepository.findAll().stream()
                .map(course->mapperUtil.convert(course,new CourseDTO()))
                .collect(Collectors.toList());
     }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {

        Course course = mapperUtil.convert(courseDTO, new Course());

        courseRepository.findById(courseId).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);
        });

    }

    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);

    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();

    }
}
