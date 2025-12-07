package com.devmind.springapp.homeworkc20.controllers;

import com.devmind.springapp.homeworkc20.models.Profesor;
import com.devmind.springapp.homeworkc20.service.UnivService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {



    private final UnivService univService;


    @Autowired
    public ProfesorController(UnivService univService) {
        this.univService = univService;
    }

    // Punctul 1

    @GetMapping("/{id}")
    public Profesor getProfesorById(@PathVariable Integer id) {
        return univService.getProfesorById(id);
    }

    @GetMapping("/materii/{id}")
    public Profesor getMateriiFromProfesor (@PathVariable Integer id) {
        return univService.getProfesorWithMaterii(id);
    }













}
