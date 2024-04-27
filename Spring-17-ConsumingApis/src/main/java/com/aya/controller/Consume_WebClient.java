package com.aya.controller;

import com.aya.dto.ResponseWrapper;
import com.aya.entity.Cinema;
import com.aya.entity.Genre;
import com.aya.entity.MovieCinema;
import com.aya.repository.CinemaRepository;
import com.aya.repository.GenreRepository;
import com.aya.repository.MovieCinemaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private WebClient webClient=WebClient.builder().baseUrl("http://localhost:8080").build();

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


//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }



    @GetMapping("/cinema")
    public Flux<Cinema> readByIdTest(){

        return Flux.fromIterable(cinemaRepository.findAll());
    }


    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> readById(@PathVariable("id") Long id){
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }


    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){

        Genre createdGenre=genreRepository.save(genre);

        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));

    }

    @GetMapping("/flex-genre")
    public Flux<Genre> getAllGenre(){

        return Flux.fromIterable(genreRepository.findAll());
    }



    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteById(@PathVariable("id") Long id){
       genreRepository.deleteById(id);

       return Mono.empty();
    }

//    ================================WEB_CLIENT===============================

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){

        return webClient
                .get()
                .uri("/flex-movie-cinema")
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }


    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);


    }

}
