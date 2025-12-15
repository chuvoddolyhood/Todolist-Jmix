package com.example.Todolist_Jmix.UI.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H3;

public class MainLayout extends AppLayout {

    public MainLayout() {
        addToNavbar(new H3("ToDo App"));
    }
}

