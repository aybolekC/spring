package com.aya.controller;



import com.aya.entity.ResponseWrapper;
import com.aya.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController//@Controller + @ResponseBody
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Aya's_App.V3")
                .body(new ResponseWrapper("test", courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id")Long courseId){
        return ResponseEntity
                .ok(new ResponseWrapper("course"+courseId+"retrived"
                        ,courseService.getCourseById(courseId)));

    }

}
