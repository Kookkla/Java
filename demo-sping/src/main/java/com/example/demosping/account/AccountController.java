package com.example.demosping.account;

import com.example.demosping.postgateway.PostGateway;
import com.example.demosping.postgateway.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepostory;

    @GetMapping("V1/account/{id}")
    public AccountResponse getById(@PathVariable int id){
        Optional<Account> account = accountRepostory.findById(id);
        if(account.isPresent()){
            AccountResponse accountRes = new AccountResponse();
            accountRes.setId(account.get().getAccountId());
            accountRes.setAge(account.get().getAge());
            accountRes.setName(account.get().getAccountName());

            return accountRes;
        }
        throw new RuntimeException("Account not found widthid" + id);
    }

    private PostGateway postGateway;

    @GetMapping("V1/post/{id}")
    public PostResponse getPostById(@PathVariable int id){
        Optional<PostResponse> result = postGateway.getPostById(id);
        return result.get();
    }


}
