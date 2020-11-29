package com.example.demosping.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository
        extends CrudRepository<Account, Integer> {
//    public void findByAccountNameAndAge(String name, int age);
}