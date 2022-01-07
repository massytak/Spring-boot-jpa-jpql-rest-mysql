package com.f2i.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.f2i.dao.TodoJpaRepository;
import com.f2i.dao.UserJpaRepository;
import com.f2i.dto.UserDto;
import com.f2i.entities.Todo;
import com.f2i.entities.User;
import com.f2i.service.UserService;

@Service
public class UserserviceImpl implements UserService {
	@Autowired
	private UserJpaRepository userdao;
	
	@Autowired
	private TodoJpaRepository todoDao;
	
	@Override
	public void createUser(User user) {
		userdao.save(user);
		
	}

	@Override
	@Transactional
	public void userTodoToUser(int idUser, long idTodo) {
		//getUser
		User user=userdao.findById(idUser).get();
		//getTodo
		Todo todo=todoDao.findById(idTodo).get();
		//attache le todo a l'utilsateur
		todo.setUser(user);
		user.getTodos().add(todo);
		//maj la base de donnee
		userdao.save(user);
		
	}

	@Override
	public List<User> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userdao.findByEmail(email);
	}

	@Override
	public List<User> findByNameAndStatus(String name, boolean statut) {
		
		return userdao.findByNameAndStatut(name, statut);
	}

	@Override
	public List<User> findByEmailJPql() {
		
		return userdao.getHenry();
	}

	@Override
	public List<User> findByEmailJPql2(String email) {
		
		return userdao.getUserByMail(email);
	}
	
	public List<User> getActiveUser(int i){
		return userdao.getActiveUser();
	}

	@Override
	public List<UserDto> findAllUser() {
		//userFrom database
		List<User> users=userdao.findAll();
		//create user list
		List<UserDto> userDto= new ArrayList<UserDto>();
		//copied le contenue de user dans userdto
		for (User user : users) {
			
			UserDto dto=new UserDto();
			
			//************1er methode
			//frce brut
//			dto.setId(user.getId());
//			dto.setEmail(user.getEmail());
//			dto.setName(user.getName());
//			dto.setStatut(user.isStatut());
			
			//**************ou la 2eme methode
			//sans la force brute
			BeanUtils.copyProperties(user, dto);
			
			userDto.add(dto);
		}
		return userDto;
	}

	@Override
	public UserDto createUser(UserDto user) {
		User user1=new User();
		BeanUtils.copyProperties(user, user1);
		user1=userdao.save(user1);
		BeanUtils.copyProperties(user1, user);
		
		return user;
	}


	

	


	

}
