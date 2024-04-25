package com.aya.repository;

import com.aya.entity.Account;
import com.aya.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    //--------------------DERIVED QUERIES-------------------------------------------//
    //write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirstBySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocationCountry(String country);


    //write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name,String sponsoredName);

    //--------------------JPQL QUERIES-------------------------------------------//

    //write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE c.id=?1")
    String fetchById(@Param("id") Long id);

    //--------------------Native QUERIES-------------------------------------------//

    //write a native query to read all cinemas by location country
    @Query(value ="SELECT * FROM cinema c JOIN location l ON l.id=c.location_id WHERE l.country=?1", nativeQuery = true)
    List<Cinema> readCinemaByLocationCountry(@Param("locationCountry") String locationCountry);


    //write a native query to read all cinemas by name or sponsored name contains specific pattern
    @Query(value = "SELECT * FROM cinema where name ILIKE concat('%',?1,'%') " +
            "OR sponsored_name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Cinema> retrieveBySearchCriteria(@Param("pattern") String pattern);


    //write a native query to sort all cinemas by name
    @Query(value ="SELECT * FROM cinema ORDER BY name ASC ", nativeQuery = true)
    List<Cinema> sortByName();

    //write a native query to distinct all cinemas by sponsored name
    @Query(value ="SELECT DISTINCT sponsored_name FROM cinema", nativeQuery = true)
    List<Cinema> sortDistinctBySponsoredName();






}
