package com.f2i.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.f2i.entities.Todo;

public interface TodoService {

	List<Todo> findAllTodos();

	Todo findByIdTodos(Long id);

	ResponseEntity<Void> deleteByIdTodos(Long id);

	ResponseEntity<Todo> saveTodos(Todo todo);

}
