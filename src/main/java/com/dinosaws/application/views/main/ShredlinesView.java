package com.dinosaws.application.views.main;

import com.dinosaws.application.data.shredlines.Shredlines;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShredlinesView extends Div {
    private HashMap<String, String> shredlines;

    public ShredlinesView(){
        Shredlines shredlinesGenerator = new Shredlines();
        try {
            this.shredlines = shredlinesGenerator.generateShredlines(3);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        for (String headline: shredlines.keySet()) {
            add(new H1(headline), new H3(shredlines.get(headline)));
        }
    }


}
