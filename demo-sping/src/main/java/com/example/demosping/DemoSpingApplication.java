package com.example.demosping;

import com.example.demosping.account.Account;
import com.example.demosping.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoSpingApplication {
	@Autowired AccountRepository repository;

	@PostConstruct
	public void intialDataForTesting(){
		Account kookkla = new Account();
		kookkla.setAccountId(1);
		kookkla.setAccountName("kookkla for test");
		kookkla.setAge(30);

		repository.save(kookkla);
	}
	public static void main(String[] args) {
		//SpringApplication.run(DemoSpingApplication.class, args);

		//gradlew bootrun
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoSpingApplication.class,args);
		for (String bean : ctx.getBeanDefinitionNames()) {
			System.out.println(bean);
		}

		System.out.println(ctx.getBeanDefinitionCount());
	}

}
