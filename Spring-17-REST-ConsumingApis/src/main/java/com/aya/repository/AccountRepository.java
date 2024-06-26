package com.aya.repository;

import com.aya.entity.Account;
import com.aya.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    //--------------------DERIVED QUERIES-------------------------------------------//
    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAllByStateOrCountry(String state, String country);


    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeIsLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAllByRoleIs(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAllByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAllByAddressStartingWith(String keyword);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAllByOrderByAgeDesc();

    //--------------------JPQL QUERIES-------------------------------------------//

    //write JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> fetchAllAccounts();

    //write JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role='ADMIN'")
    List<Account> fetchAllAdminAccounts();

    //write JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a order by a.age asc ")
    List<Account> fetchAccountsSortedByAge();

    //--------------------Native QUERIES-------------------------------------------//

    //write a native query to read all accounts with an age lower than a specific value
    @Query(value ="SELECT * FROM account_details where age<?1", nativeQuery = true)
    List<Account> readAccountsWithAgeLowerThan(@Param("age") Integer age);


    //write a native query to read all accounts that a specific value can be containable in the name, address, country, state, city
    @Query(value = "SELECT * FROM account_details where name ILIKE concat('%',?1,'%') " +
            "OR country ILIKE concat('%',?1,'%') " +
            "OR address ILIKE concat('%',?1,'%') " +
            "OR state ILIKE concat('%',?1,'%') " +
            "OR city ILIKE concat('%',?1,'%') ", nativeQuery = true)
    List<Account> retrieveBySearchCriteria(@Param("pattern") String pattern);


    //write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details where age>?1", nativeQuery = true)
    List<Account> readAccountsWithAgeHigherThan(@Param("age") Integer age);


}
