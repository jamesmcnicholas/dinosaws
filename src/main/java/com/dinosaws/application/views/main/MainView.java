package com.dinosaws.application.views.main;

import com.dinosaws.model.Dinosaw;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;

@PageTitle("Main")
@Route("")
public class MainView extends VerticalLayout {

    //TODO - This is disgusting - can we class-ify it?
    private final String DINOSAUR_HEIGHT = "256px";
    private final String DINOSAUR_WIDTH = "144px";
    private final ComponentRenderer<Component, Dinosaw> dinoCardRenderer= new ComponentRenderer<>(
            dinosaw -> {
                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.setMargin(true);

                Image avatar = dinosaw.getLatestImage();
                avatar.setHeight(DINOSAUR_HEIGHT);
                avatar.setWidth(DINOSAUR_WIDTH);

                VerticalLayout infoLayout = new VerticalLayout();
                infoLayout.setSpacing(false);
                infoLayout.setPadding(false);
                infoLayout.getElement().appendChild(
                        ElementFactory.createStrong(dinosaw.getName()));
                infoLayout.add(new Div(new Text(dinosaw.getDescription())));

                VerticalLayout contactLayout = new VerticalLayout();
                contactLayout.setSpacing(false);
                contactLayout.setPadding(false);
                contactLayout.add(new Div(new Text("person.getEmail()")));
                contactLayout
                        .add(new Div(new Text("person.getAddress().getPhone()")));
                infoLayout
                        .add(new Details("Contact information", contactLayout));

                cardLayout.add(avatar, infoLayout);
                return cardLayout;
            });




    public MainView() {
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
        });
        addButton.addClickShortcut(Key.ENTER);

        FileBuffer fileBuffer = new FileBuffer();
        Upload singleFileUpload = new Upload(fileBuffer);

        singleFileUpload.addSucceededListener(event -> {
            // Get information about the file that was written to the file system
            FileData savedFileData = fileBuffer.getFileData();
            String absolutePath = savedFileData.getFile().getAbsolutePath();

            System.out.printf("File saved to: %s%n", absolutePath);
            add(new Image(absolutePath, "img"));
        });

        // Initiate test dino data
        List<Dinosaw> dinosawList = Arrays.asList(
                new Dinosaw("Nicolaus", "Little man", new Image("images/dino1.jpg", "dino 1")),
                new Dinosaw("Galileo", "Sweet Talker", new Image("images/dino2.png", "dino 2")),
                new Dinosaw("Diego", "A hearty boy", new Image("images/dino3.jpg", "dino 3"))
        );

        // Set up list of dinos
        VirtualList<Dinosaw> dinos = new VirtualList<>();
        dinos.setItems(dinosawList);
        dinos.setRenderer(dinoCardRenderer);


        // Create all elements of the site
        add(
            // Header
            new AppLayoutBasic(),

            // Context
            new H1("An IRL scavenger hunt with dinosaurs!"),
            new HorizontalLayout(
                new VerticalLayout(
                        new Text("The dinos were originally airdropped around Wimbledon, but who knows where they are now!\n"),
                        new Text("Take a look below to see the latest clues for each dino.")),
                new Image("images/diegochute.png", "Diego parachutes in")
            ),

            // Dino list
            dinos,

            // If you found a dino
            new H2("Did you see a dino?"),
            new Text("Scan their QR code, move them somewhere else public, and upload a pic for someone else to find them!"),
            singleFileUpload

        );
    }


}
