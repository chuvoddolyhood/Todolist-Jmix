package com.example.Todolist_Jmix.UI.layout;

import com.example.Todolist_Jmix.UI.view.profile.ProfileView;
import com.example.Todolist_Jmix.UI.view.state.StatsView;
import com.example.Todolist_Jmix.UI.view.todo.TodoView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightCondition;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayout extends AppLayout {

    public MainLayout() {
    	createHeader();
    	createDrawer();
    }
    
	// ================= HEADER =================
    private void createHeader() {
        H2 logo = new H2("ToDo App");
        logo.addClassNames(
                LumoUtility.Margin.NONE,
                LumoUtility.FontSize.LARGE
        );

        addToNavbar(logo);
    }
    
	// ================= SIDEBAR =================
    private void createDrawer() {
        RouterLink todoLink = new RouterLink("To Do", TodoView.class);
        RouterLink statsLink = new RouterLink("Stats", StatsView.class);
        RouterLink profileLink = new RouterLink("Profile", ProfileView.class);
        
        todoLink.setHighlightCondition(HighlightConditions.sameLocation());

        Nav nav = new Nav(
                new VerticalLayout(
                        todoLink,
                        statsLink,
                        profileLink
                )
        );

        addToDrawer(nav);
    }
}

