package com.aya.repository;

import com.aya.entity.Movie;
import com.aya.entity.Ticket;
import com.aya.entity.User;
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
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    //--------------------DERIVED QUERIES-------------------------------------------//

    //write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);

    //write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserEmail(String email);
    //write a derived query to count how many tickets are sold for a specific movie
   Integer countAllByMovieCinemaMovieName(String name);

    //write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);


    //--------------------JPQL QUERIES-------------------------------------------//

    //write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.user.id=?1")
    List<Ticket> fetchAllTicketsBoughtByUser(@Param("userId") Long userId);

    //write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime between ?1 and ?2")
    List<Ticket> readAllTicketsInRangeOfDates(@Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2")LocalDateTime dateTime2);

    //--------------------Native QUERIES-------------------------------------------//

    //write a native query to count the number of tickets a user bought
    @Query(value ="SELECT COUNT(*) FROM ticket WHERE user_id=?1", nativeQuery = true)
    Integer countByUser(@Param("userId") Long userId);
    //write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value ="SELECT COUNT(*) FROM ticket WHERE user_id=?1 AND date_time BETWEEN ?2 AND ?3", nativeQuery = true)
    Integer countByUserSpecificDate(@Param("userId") Long userId, @Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);

    //write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT(m.name) FROM ticket t JOIN movie_cinema mc ON mc.id=t.movie_cinema_id JOIN movie m ON mc.movie_id=m.id", nativeQuery = true)
    List<String> retrieveAllDistinctMovieNames();

    //write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user u ON u.id=t.user_id  WHERE  u.email=?1", nativeQuery = true)
    List<Ticket> retrieveAllTicketsByEmail(@Param("email") String email);

    //write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> retrieveAllTickets();


    //write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
//    @Query(value = "SELECT * FROM ticket t JOIN user u ON u.id=t.user_id  WHERE  u.email=?1", nativeQuery = true)
//    List<Ticket> retrieve(@Param("email") String email);


}
