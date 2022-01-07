package com.f2i.service;

import java.util.List;

import com.f2i.dto.UserDto;
import com.f2i.entities.User;

public interface UserService {

	void createUser(User user1);

	void userTodoToUser(int idUser, long idTodo);

	List<User> findUserByEmail(String email);

	
	List<User> findByNameAndStatus(String name,boolean statut);
	List<User> findByEmailJPql();

	List<User> findByEmailJPql2(String email);

	List<User> getActiveUser(int i);

	List<UserDto> findAllUser();

	UserDto createUser(UserDto user);


}
