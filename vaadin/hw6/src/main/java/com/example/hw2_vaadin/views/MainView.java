package com.example.hw2_vaadin.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        add(new Button("Manage Data Models", e -> getUI().ifPresent(ui -> ui.navigate("data-models"))));
       
    }
}
