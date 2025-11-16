package com.devmind.springapp.rest_demo.services;

import com.devmind.springapp.rest_demo.dtos.CourseInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final ObjectMapper mapper;




    public CourseInfo[] getCourseFromJSON() throws IOException {
        try{
            ClassPathResource resource = new ClassPathResource("course.json");
            try(InputStream in = resource.getInputStream()){
                return mapper.readValue(in, CourseInfo[].class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Nu se poate citi JSON",e);
        }
    }
}
