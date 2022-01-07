package com.f2i.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.f2i.entities.User;

public interface UserJpaRepository extends JpaRepository<User, Integer>{
	//dsl ==> Select * from User where email=parametrerdelamethode
	List<User> findByEmail(String email);

	List<User> findByNameAndStatut(String name, boolean statut);
	
	@Query("SELECT u FROM User u WHERE u.email='Heanry'")
	List<User> getHenry();
	
	@Query("SELECT u FROM User u WHERE u.email=:toto")
	List<User> getUserByMail(@Param("toto")String mail);
	
	@Query(value="SELECT * FROM user WHERE statut=1",nativeQuery = true)
	List<User> getActiveUser();
}
