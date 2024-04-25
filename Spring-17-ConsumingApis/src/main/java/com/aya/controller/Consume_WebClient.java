package com.aya.controller;

import com.aya.entity.Cinema;
import com.aya.entity.Genre;
import com.aya.entity.MovieCinema;
import com.aya.repository.CinemaRepository;
import com.aya.repository.GenreRepository;
import com.aya.repository.MovieCinemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;
    private final CinemaRepository cinemaRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository, CinemaRepository cinemaRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/flex-movie-cinema")
    public Flux<MovieCinema> readAllCinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }


    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
        return Mono.just(movieCinemaRepository.findById(id).get());
    }



    @GetMapping("/cinema")
    public Flux<Cinema> readById(){
        return Flux.fromIterable(cinemaRepository.findAll());
    }
}
