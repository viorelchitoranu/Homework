package com.devmind.springapp.homeworkc20.repository;

import com.devmind.springapp.homeworkc20.models.Materie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Integer> {
}
