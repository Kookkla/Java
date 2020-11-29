package com.example.demosping.account;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Account2Repository
        extends CrudRepository<Account, Integer> {

//    @Query("select * from account where account_name=:name")
//    List<Account> findByName(@Param("name") String name);
//
//    @Modifying
//    @Query("UPDATE account SET account_name = :name WHERE account_id = :id")
//    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);
}