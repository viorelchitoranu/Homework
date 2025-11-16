package com.devmind.springapp.rest_demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CourseInfo {
    private String courseName;
    private Trainer trainer;
    private boolean online;
    private List<CourseDay> courseDays;



}
