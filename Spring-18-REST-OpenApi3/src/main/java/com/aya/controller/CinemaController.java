package com.aya.controller;


import com.aya.entity.Cinema;
import com.aya.entity.User;
import com.aya.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Cinema", description = "Cinema CRUD operations")
public class CinemaController {


    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemas")
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAllCinemas(){

        return cinemaRepository.findAll();
    }

}
