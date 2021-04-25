package tasky.java.gui;

import java.time.LocalDate;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import tasky.java.model.State;
import tasky.java.model.Task;
import tasky.java.model.TaskData;

public class ApplicationUI extends BorderPane {

  private BottomArea bottomArea;
  private CenterArea centerArea;
  private RightArea rightArea;
  private Details details;
  private static LongProperty taskSelected;
  private static ObservableList<Task> observableList;


  public ApplicationUI() {
    taskSelected = new SimpleLongProperty();
    observableList = FXCollections.observableArrayList();
    initializeControls();
    layoutControls();

    observableList
        .add(new Task(new TaskData("A2", "B", State.TODO, LocalDate.parse("2001-08-21"))));
    observableList
        .add(new Task(new TaskData("A2", "B", State.DOING, LocalDate.parse("2001-08-21"))));
    observableList
        .add(new Task(new TaskData("A2", "B", State.DONE, LocalDate.parse("2001-08-21"))));

    details = new Details(rightArea);
    taskSelected.bindBidirectional(details.getIdProperty());
  }


  public static ObservableList<Task> getRepository() {
    return observableList;
  }

  public void displayTask() {

  }

  public static void updateTaskSelected(long id) {
    taskSelected.set(id);
  }

  private void initializeControls() {
    bottomArea = new BottomArea(taskSelected);
    centerArea = new CenterArea();
    rightArea = new RightArea();
  }

  private void layoutControls() {
    this.setPadding(new Insets(20));
    this.setBottom(bottomArea);
    this.setCenter(centerArea);
    this.setRight(rightArea);
  }
}
