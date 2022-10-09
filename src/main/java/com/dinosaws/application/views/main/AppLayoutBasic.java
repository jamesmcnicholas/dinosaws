package com.dinosaws.application.views.main;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;

public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic() {
        H1 title = new H1("Dinosaws!");
        title.getStyle().set("font-size", "var(--lumo-font-size-xxxl)")
                .set("padding", "10")
                .set("margin", "10");

        Image diegoImage = new Image("images/diego.png", "Diego the dino!");
        diegoImage.setWidth(64, Unit.PIXELS);
        addToNavbar(title, diegoImage);
    }
}
