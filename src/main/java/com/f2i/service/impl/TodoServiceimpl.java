package com.f2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.f2i.dao.TodoJpaRepository;
import com.f2i.entities.Todo;
import com.f2i.service.TodoService;

@Service
public class TodoServiceimpl implements TodoService {
	@Autowired
	private TodoJpaRepository todoJpa;

	@Override
	public List<Todo> findAllTodos() {	
		return todoJpa.findAll();
	}

	@Override
	public Todo findByIdTodos(Long id) {	
		return todoJpa.findById(id).get();
	}

	@Override
	public ResponseEntity<Void> deleteByIdTodos(Long id) {
		todoJpa.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}

	@Override
	public ResponseEntity<Todo> saveTodos(Todo todo) {
		Todo newTodo=todoJpa.save(todo);
		System.out.println(newTodo);
		return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
	}
	
	
}
