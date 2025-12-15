package com.example.Todolist_Jmix.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Todolist_Jmix.Entity.Todo;
import com.example.Todolist_Jmix.Repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> findAll() {
        return repo.findAll();
    }

    public Todo save(Todo todo) {
        return repo.save(todo);
    }

    public void delete(Todo todo) {
        repo.delete(todo);
    }
}

