package com.aya.repository;

import com.aya.entity.Account;
import com.aya.entity.Cinema;
import com.aya.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    //--------------------JPQL QUERIES-------------------------------------------//

    //write a JPQL query that return all genres
    @Query("SELECT g FROM Genre g")
    List<Genre> fetchAllGenres();

    //--------------------Native QUERIES-------------------------------------------//

    //write a native query that returns genres by containing name
    @Query(value = "SELECT * FROM genre where name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Genre> retrieveGenresBySearchCriteria(@Param("name") String name);

}
