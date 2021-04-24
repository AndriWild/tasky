package tasky.java.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskLabel extends Label {
    private static final int TASK_HEIGHT = 80;
    private static final int TASK_WIDTH = 80;
    private final int id;

    Button button;

    public TaskLabel(String title, int id) {
        super(title);
        this.id = id;

        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        this.setStyle("-fx-background-color: LIGHTGREY;");
        this.setPrefHeight(TASK_HEIGHT);
        this.setPrefWidth(TASK_WIDTH);
        this.setOnMouseClicked(event -> System.out.println("Task clicked: " + id));
    }

    private void layoutControls() {}


}
