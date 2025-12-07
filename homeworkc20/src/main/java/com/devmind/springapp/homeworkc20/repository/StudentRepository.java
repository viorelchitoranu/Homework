package com.devmind.springapp.homeworkc20.repository;

import com.devmind.springapp.homeworkc20.models.Profesor;
import com.devmind.springapp.homeworkc20.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    Optional<Student> findByNume(String nume);
    Optional<Student> findByNumeAndPrenume(String nume, String prenume);


}
