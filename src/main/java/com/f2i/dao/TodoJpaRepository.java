package com.f2i.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f2i.entities.Todo;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>{

}
