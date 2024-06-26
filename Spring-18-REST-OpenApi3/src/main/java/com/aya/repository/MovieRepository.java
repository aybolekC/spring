package com.aya.repository;

import com.aya.entity.Account;
import com.aya.entity.Cinema;
import com.aya.entity.Movie;
import com.aya.entity.MovieCinema;
import com.aya.enums.MovieState;
import com.aya.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //--------------------DERIVED QUERIES-------------------------------------------//

    //write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal price1, BigDecimal price2);

    //write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> durations);

    //write a derived query to list all movies with higher than specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDateTime dateTime);

    //write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    //--------------------JPQL QUERIES-------------------------------------------//

    //write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> readAllMoviesBetweenPriceRange(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    //write a JPQL query that returns all movie names
    @Query("SELECT distinct m.name FROM Movie m")
    List<String> readAllMoviesNames();


    //--------------------Native QUERIES-------------------------------------------//

    //write a native query that returns a movie by name
    @Query(value ="SELECT * FROM movie WHERE name=?1", nativeQuery = true)
    Optional<Movie> findByNameNew(@Param("name") String name);

    //write a native query that returns the list of movies in a specific range of prices
    @Query(value ="SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> findAllByPriceRange(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    //write a native query to return all movies where duration exists in the range of duration
    @Query(value ="SELECT * FROM movie WHERE duration IN ?1", nativeQuery = true)
    List<Movie> retrieveByDurationInRange(@Param("durations") List<Integer> durations);

    //write a native query to list the top 5 most expensive movies
    @Query(value ="SELECT * FROM movie Order By price Decs Limit 5", nativeQuery = true)
    List<Movie> topFiveExpensiveMovies();


}
