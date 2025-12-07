package com.devmind.springapp.homeworkc20.repository;

import com.devmind.springapp.homeworkc20.models.Adresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Integer> {
}
