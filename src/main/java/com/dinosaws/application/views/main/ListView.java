package com.dinosaws.application.views.main;

import com.dinosaws.application.data.service.DinosawService;
import com.dinosaws.application.data.entity.Dinosaw;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.stereotype.Component;

@Component
public class ListView extends VerticalLayout {
    Grid<Dinosaw> grid;
    TextField filterText = new TextField();
    TextField form;
    DinosawService service;

    public ListView(DinosawService service) {
        this.service = service;
        form = new TextField();
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        FlexLayout content = new FlexLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.setFlexShrink(0, form);
        content.addClassNames("content", "gap-m");
        content.setSizeFull();

        add(getToolbar(), content);
        updateList();
    }

    private void configureGrid() {
        grid = new Grid<>(Dinosaw.class);
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("name", "description");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {
        grid.setItems(service.findAllDinosaws(filterText.getValue()));
    }
}
