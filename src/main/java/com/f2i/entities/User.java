package com.f2i.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String email;
	private boolean statut;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Todo> todos=new ArrayList<Todo>();

	//******************constructeur *******************//
	public User(String email, boolean statut) {
		super();
		this.email = email;
		this.statut = statut;
	}

	public User() {
		super();
	}
	//********************get/set*************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name, String email, boolean statut) {
		super();
		this.name = name;
		this.email = email;
		this.statut = statut;
	}

	//***************************get/set*********************
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

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", statut=" + statut + "]";
	}

	
	
	
	

}
