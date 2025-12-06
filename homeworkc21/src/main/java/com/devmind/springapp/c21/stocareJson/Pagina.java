package com.devmind.springapp.c21.stocareJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pagina {

    public int page;

    @JsonProperty("results")

    public List<Film> filme = new ArrayList<>();

    public int total_pages;
    public int total_results;

    public Pagina(List<Film> filme, int page, int total_pages, int total_results) {
        this.filme = filme;
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public Pagina() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Film> getFilme() {
        return filme;
    }

    public void setFilme(List<Film> filme) {
        this.filme = filme;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public void addFilm(Film film) {
        filme.add(film);
    }


}
