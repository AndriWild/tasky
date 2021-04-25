package tasky.java.gui;

import javafx.beans.property.LongProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import tasky.java.model.State;
import tasky.java.model.Task;
import tasky.java.model.TaskData;

public class BottomArea extends HBox {

  HBox buttonRow;
  LongProperty taskSelected;

  public BottomArea(LongProperty taskSelected) {
    this.taskSelected = taskSelected;
    this.setPadding(new Insets(10));

    this.minHeight(100);
    initializeControls();

    layoutControls();
  }

  private void initializeControls() {
    Button btnNew = new Button("New");
    Button btnRefresh = new Button("Refresh");
    buttonRow = new HBox(btnNew, btnRefresh);
    buttonRow.setSpacing(20);
    buttonRow.setPadding(new Insets(10, 10, 10, 0));

    btnNew.setOnAction(event -> createNewTask());
  }

  private void createNewTask() {
    Task newTask = new Task(new TaskData("", "", State.TODO, null));
    ObservableList<Task> list = ApplicationUI.getRepository();
    list.add(newTask);
    taskSelected.set(newTask.getId());
  }

  private void layoutControls() {
    this.getChildren().add(buttonRow);
  }

}
