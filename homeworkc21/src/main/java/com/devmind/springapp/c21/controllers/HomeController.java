package com.devmind.springapp.c21.controllers;

import com.devmind.springapp.c21.service.MovieService;
import com.devmind.springapp.c21.stocareJson.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class HomeController {

    @Autowired
    private  MovieService movieService;




    // GET
    @GetMapping
    public List<Film> getAllMovies() {
        return movieService.getToateFilmele();
    }

    @GetMapping("/search")
    public List <Film> searchMovieByTitle(@RequestParam String title) {
        return movieService.searchByTitle(title);
    }

    @GetMapping("/{id}")
    public Film getMovieById(@PathVariable int id) {
        return movieService.getFilmById(id);
    }


    //POST
    @PostMapping
    public Film addMovie(@RequestBody Film film) {
        return movieService.addFilm(film);
    }

    @PostMapping("/import")
    public String importMovie() {
        movieService.importMoviesFromTMDBOnDemand();
        return "Filmele au fost importate din TMDB in baza de date.";
    }

    //PUT
    @PutMapping("/{id}")
    public Film updateMovie(@PathVariable int id, @RequestBody Film film) {
        return movieService.editFilm(id, film);
    }


    public static class UpdateRatingRequest {
        public Double rating;
    }

    @PutMapping("/{id}/rating")
    public Film updateMovieRating(@PathVariable int id, @RequestBody UpdateRatingRequest request) {
        return movieService.updateRating(id, request.rating);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteFilm(id);
        return "Film sters";
    }








}
