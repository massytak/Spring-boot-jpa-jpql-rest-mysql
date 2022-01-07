package com.f2i.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

	private int id;

	private String name;
	private String email;
	private boolean statut;

	private List<TodoDto> todos = new ArrayList<TodoDto>();

	// ******************constructeur *******************//
	public UserDto(String email, boolean statut) {
		super();
		this.email = email;
		this.statut = statut;
	}

	public UserDto() {
		super();
	}

	// ********************get/set*************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDto(String name, String email, boolean statut) {
		super();
		this.name = name;
		this.email = email;
		this.statut = statut;
	}

	// ***************************get/set*********************
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public List<TodoDto> getTodos() {
		return todos;
	}

	public void setTodos(List<TodoDto> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", statut=" + statut + "]";
	}

}
