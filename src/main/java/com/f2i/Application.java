package com.f2i;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.f2i.entities.User;
import com.f2i.service.UserService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1=new User("jea","Heanry",true);
		User user2=new User("jean","Heanry",true);
		userService.createUser(user1);
		userService.createUser(user2);
		//associer user a todo
		userService.userTodoToUser(2,11);
		userService.userTodoToUser(2,12);
		
		//springboot dsl
		List<User> user12=userService.findUserByEmail("Heanry");
		System.out.println(user12);
		
		List<User> user21=userService.findByNameAndStatus("jean",true);	
		System.out.println(user21);
			
		List<User> l1=userService.findByEmailJPql();
		System.out.println(l1);
		System.out.println("***********************************************");
		List<User> l2=userService.findByEmailJPql2("Hanr");
		System.out.println(l2);
		System.out.println("***********************Native query SQL************************");
		List<User> l3=userService.getActiveUser(1);
		System.out.println(l3);
		
	}

}
