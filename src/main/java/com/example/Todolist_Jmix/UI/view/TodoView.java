package com.example.Todolist_Jmix.UI.view;

import com.example.Todolist_Jmix.Service.TodoService;
import com.example.Todolist_Jmix.UI.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class TodoView extends VerticalLayout {

    private final TodoService service;

    public TodoView(TodoService service) {
        this.service = service;
        // UI code
    }
}

