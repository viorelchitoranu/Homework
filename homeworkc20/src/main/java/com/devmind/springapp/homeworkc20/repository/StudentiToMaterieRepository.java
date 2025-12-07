package com.devmind.springapp.homeworkc20.repository;


import com.devmind.springapp.homeworkc20.models.StudentiToMaterie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentiToMaterieRepository extends JpaRepository<StudentiToMaterie, Integer> {

}
