package com.devmind.springapp.homeworkc20.repository;

import com.devmind.springapp.homeworkc20.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>, JpaSpecificationExecutor<Profesor> {

}
