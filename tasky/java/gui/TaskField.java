package tasky.java.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import tasky.java.model.State;
import tasky.java.model.Task;

public class TaskField extends FlowPane {
  private static final int TASKFIELD_HEIGHT = 500;
  private static final int TASKFIELD_WIDTH = Integer.MAX_VALUE;
  private String color;
  private List<TaskLabel> labels;
  private final State state;


  public TaskField(String color, State state) {
    this.color = color;
    this.state = state;
    initializeControls();
    layoutControls();
  }


  private void initializeControls() {
    this.setStyle("-fx-background-color: #" + color + ";");
    this.setPrefHeight(TASKFIELD_HEIGHT);
    this.setPrefWidth(TASKFIELD_WIDTH);
    this.setMaxHeight(TASKFIELD_HEIGHT);
    this.setHgap(10);
    this.setVgap(10);
    this.setPadding(new Insets(5));
    System.out.println("TaskField.initializeControls()");
    labels = new ArrayList<>();
    ListChangeListener<Task> listener = change -> {
      List<Task> list = change.getList().stream().filter(e -> e.getStatus() == state)
          .collect(Collectors.toList());
      labels.clear();
      for (Task task : list) {
        labels.add(new TaskLabel(task.getTitle(), task.getId()));

      }
      this.getChildren().addAll(labels);
    };
    ApplicationUI.getRepository().addListener(listener);
  }

  private void layoutControls() {
    this.getChildren().addAll(labels);
  }
}
