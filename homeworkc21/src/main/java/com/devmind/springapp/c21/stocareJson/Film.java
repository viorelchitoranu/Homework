package com.devmind.springapp.c21.stocareJson;

import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="films")
@Getter
@Setter
@ToString

public class Film {
    @Id
    public int id;

    public boolean adult;

    @Column(name = "backdrop_path")
    public String backdrop_path;

    @ElementCollection
    @CollectionTable(
            name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id")
    )
    @Column(name = "genre_id")
    public List<Integer> genre_ids = new ArrayList<>();



    public String original_language;
    public String original_title;

    @Column(columnDefinition = "TEXT")
    public String overview;
    public double popularity;

    @Column(name = "poster_path")
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;



    public Film() {}


    public Film(int id,
                boolean adult,
                String backdrop_path,
                ArrayList<Integer> genre_ids,
                String original_language,
                String original_title,
                String overview,
                double popularity,
                String poster_path,
                String release_date,
                String title,
                boolean video,
                double vote_average,
                int vote_count) {
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.genre_ids = genre_ids;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
