package com.devmind.springapp.rest_demo.controllers;

import com.devmind.springapp.rest_demo.dtos.CourseInfo;
import com.devmind.springapp.rest_demo.services.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;



    @GetMapping("/course")
    public CourseInfo[] getCourse() throws IOException {

        return courseService.getCourseFromJSON();

    }


}
