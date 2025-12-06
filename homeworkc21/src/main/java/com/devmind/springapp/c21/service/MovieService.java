package com.devmind.springapp.c21.service;

import com.devmind.springapp.c21.repository.FilmRepository;
import com.devmind.springapp.c21.stocareJson.Film;
import com.devmind.springapp.c21.stocareJson.Pagina;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieService {

    @Value("${tmdb.read-access-token}")
    private String READ_ACCES_TOKEN;

    private static final String TMDB_MOVIES_URL = "https://api.themoviedb.org/3/discover/movie";

    private List<Pagina> pagini = new ArrayList<>();

    private final FilmRepository filmRepository;

    public MovieService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    public void importFromTMDB() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(READ_ACCES_TOKEN);
        headers.set("Accept", "application/json");
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        //ResponseEntity<Pagina> response = restTemplate.exchange(TMDB_MOVIES_URL, HttpMethod.GET, entity, Pagina.class);
        for (int page = 1; page <= 3; page++) {
            String url = TMDB_MOVIES_URL + "?page=" + page;
            ResponseEntity<Pagina> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, Pagina.class);

            Pagina paginaDinApi = response.getBody();
            if (paginaDinApi != null && paginaDinApi.getFilme() != null) {
                filmRepository.saveAll(paginaDinApi.getFilme());
            }
        }
    }

    public void importMoviesFromTMDBOnDemand(){
        importFromTMDB();
    }

    public List<Film> getToateFilmele(){
        return filmRepository.findAll();
    }

    public Film getFilmById(int id){
        return filmRepository.findById(id).orElse(null);
    }

    public List<Film> searchByTitle(String title){
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    public Film addFilm(Film film){
        return filmRepository.save(film);
    }



    public Film editFilm(int id, Film film){
        Optional<Film> filmOptional = filmRepository.findById(id);
        if(filmOptional.isEmpty()){
            return null;
        }
        Film existingFilm = filmOptional.get();

        existingFilm.setTitle(film.getTitle());

        return filmRepository.save(existingFilm);
    }
    public Film updateRating(int id, Double rating){
        Optional<Film> filmOptional = filmRepository.findById(id);
        if(filmOptional.isEmpty()){
            return null;
        }
        Film existingFilm = filmOptional.get();
        existingFilm.setVote_average(rating);

        return filmRepository.save(existingFilm);
    }

    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }








}
