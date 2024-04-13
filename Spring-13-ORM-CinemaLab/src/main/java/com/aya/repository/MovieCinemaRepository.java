package com.aya.repository;

import com.aya.entity.Account;
import com.aya.entity.Cinema;
import com.aya.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {


    //--------------------DERIVED QUERIES-------------------------------------------//

    //write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);


    //write a derived query to count all movie cinema with specific cinema id
    Integer countAllByCinemaId(Long cinemaId);


    //write a derived query to count all movie cinema with specific movie id
    Integer countAllByMovieId(Long movieId);


    //write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);



    //write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByMoviePriceDesc();


    //write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);


    //write a derived query to list all movie cinemas in specific location
    List<MovieCinema> findAllByCinemaLocationName(String locationName);


    //--------------------JPQL QUERIES-------------------------------------------//

    //write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime>?1" )
    List<MovieCinema> fetchAllMovieCinemaHigherThanThisDate(@Param("dateTime") LocalDateTime dateTime);

    //--------------------Native QUERIES-------------------------------------------//

    //write a native query to count all movie cinemas by cinema id
    @Query(value ="SELECT COUNT(*) FROM movie_cinema WHERE cinema_id=?1", nativeQuery = true)
    Integer countByCinemaId(@Param("cinemaId") Long cinemaId);

    //write a native query that returns all movie cinemas by location name

    @Query(value ="SELECT * FROM movie_cinema mc JOIN cinema c ON mc.cinema_id=c.id " +
            "JOIN location l ON l.id=c.location_id WHERE l.name=?1", nativeQuery = true)
    List<MovieCinema> getAllCinemaMovieFromGivenLocationName(@Param("name") String name);








}
