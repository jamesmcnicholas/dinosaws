package com.dinosaws.application.views.main;

import com.dinosaws.model.Dinosaw;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;

public class DinosawView extends Div {

    private Dinosaw dinosaw;

    public DinosawView(Dinosaw dinosaw) {
        this.dinosaw = dinosaw;
        add(new H1(dinosaw.getName()), dinosaw.getLatestImage(), new Text(dinosaw.getDescription()));
    }


}
