package com.example.Todolist_Jmix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Todolist_Jmix.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

