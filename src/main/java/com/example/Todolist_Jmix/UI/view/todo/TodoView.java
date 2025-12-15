package com.example.Todolist_Jmix.UI.view.todo;

import com.example.Todolist_Jmix.Entity.Todo;
import com.example.Todolist_Jmix.Service.TodoService;
import com.example.Todolist_Jmix.UI.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

@Route(value = "", layout = MainLayout.class)
public class TodoView extends VerticalLayout {

    private final TodoService service;

    private final Grid<Todo> grid = new Grid<>(Todo.class, false);
    private final TextField titleField = new TextField();
    private final Button addButton = new Button("Add");

    public TodoView(TodoService todoService) {
        this.service = todoService;

        setSizeFull();
        setPadding(true);
        setSpacing(true);

        add(
                createHeader(),
                createAddTodoBar(),
                createGrid()
        );

        refreshGrid();
    }

    // ================= HEADER =================
    private H2 createHeader() {
        return new H2("📝 To Do List");
    }

    // ================= ADD TODO =================
    private HorizontalLayout createAddTodoBar() {
        titleField.setPlaceholder("Enter a new task...");
        titleField.setWidthFull();

        addButton.addClickListener(e -> addTodo());

        HorizontalLayout layout = new HorizontalLayout(titleField, addButton);
        layout.setWidthFull();
        layout.setFlexGrow(1, titleField);

        return layout;
    }

    // ================= GRID =================
    private Grid<Todo> createGrid() {
        grid.setSizeFull();

        grid.addComponentColumn(todo -> {
            Checkbox checkbox = new Checkbox(todo.isCompleted());
            checkbox.addValueChangeListener(e -> {
                todo.setCompleted(e.getValue());
                service.save(todo);
            });
            return checkbox;
        }).setHeader("Done").setWidth("80px");

        grid.addColumn(Todo::getTitle)
                .setHeader("Task")
                .setAutoWidth(true)
                .setFlexGrow(1);

        grid.addComponentColumn(todo ->
                new Button("🗑", e -> {
                	service.delete(todo);
                    refreshGrid();
                })
        ).setHeader("Delete").setWidth("100px");

        return grid;
    }

    // ================= ACTIONS =================
    private void addTodo() {
        if (titleField.isEmpty()) {
            return;
        }

        Todo todo = new Todo();
        todo.setTitle(titleField.getValue());
        todo.setCompleted(false);

        service.save(todo);
        titleField.clear();
        refreshGrid();
    }

    private void refreshGrid() {
        grid.setItems(service.findAll());
    }
}

