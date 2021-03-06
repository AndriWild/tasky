package tasky.java.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskLabel extends Label {
    private static final int TASK_HEIGHT = 80;
    private static final int TASK_WIDTH = 80;
    private final long id;

    Button button;

    public TaskLabel(String title, int id) {
        super(title);
        this.id = id;

        initializeControls();
        layoutControls();
    }

    public void updateTitle(String title) {
        this.setText(title);
    }

    private void initializeControls() {
        this.setStyle("-fx-background-color: LIGHTGREY;" + "-fx-background-radius: 5, 4;");
        this.setPadding(new Insets(10));
        this.setPrefHeight(TASK_HEIGHT);
        this.setPrefWidth(TASK_WIDTH);
        this.setOnMouseClicked(event -> ApplicationUI.updateTaskSelected(this.id));
    }

    private void layoutControls() {}


}
