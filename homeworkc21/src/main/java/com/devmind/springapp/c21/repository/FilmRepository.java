package com.devmind.springapp.c21.repository;

import com.devmind.springapp.c21.stocareJson.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByTitleContainingIgnoreCase(String title);
}
