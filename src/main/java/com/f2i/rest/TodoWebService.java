package com.f2i.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.f2i.dto.UserDto;
import com.f2i.entities.Todo;
import com.f2i.service.TodoService;
import com.f2i.service.UserService;

@RestController
public class TodoWebService {
	@Autowired
	private TodoService todoService;
	@Autowired
	private UserService userService;
	
	@GetMapping(path ="/todos")
	public List<Todo> getAllTodos(){
		return todoService.findAllTodos();
	}
	@GetMapping(path ="/todos/{id}")
	public Todo getTodo(@PathVariable Long id) {
		return todoService.findByIdTodos(id);
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
		todoService.deleteByIdTodos(id);
		return ResponseEntity.noContent().build();
	}
	@PostMapping(path = "/todo")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
		
		
		return todoService.saveTodos(todo);
	}
	@PutMapping(path = "/todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Long id,@RequestBody Todo todo){
		todo.setId(id);
		
		
		return todoService.saveTodos(todo);
	}
	
	@GetMapping(path ="/users")
	public List<UserDto> getAllUsers(){
		return userService.findAllUser();
	}
	
	@PostMapping(path = "/user")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto user){
		UserDto newUserDto= userService.createUser(user);
		
		return new ResponseEntity<UserDto>(newUserDto,HttpStatus.OK);
	}
	
}
