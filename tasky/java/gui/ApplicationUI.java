package tasky.java.gui;

import java.time.LocalDate;
import javafx.beans.property.LongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import tasky.java.model.State;
import tasky.java.model.Task;
import tasky.java.model.TaskContainer;
import tasky.java.model.TaskData;
import tasky.java.model.TaskMap;

public class ApplicationUI extends BorderPane {

  private BottomArea bottomArea;
  private CenterArea centerArea;
  private RightArea rightArea;
  private LongProperty taskSelected;

  private TaskContainer repository = new TaskMap();
  private static ObservableList<Task> observableList;


  public ApplicationUI() {

    this.setPadding(new Insets(20));

    addTestData();
    observableList = FXCollections.observableArrayList(repository.get());
    initializeControls();
    layoutControls();
    observableList
        .add(new Task(99, new TaskData("A2", "B", State.TODO, LocalDate.parse("2001-08-21"))));

  }


  public static ObservableList<Task> getRepository() {
    return observableList;
  }

  public void displayTask() {

  }

  public static void updateTaskSelected() {

  }

  private void initializeControls() {
    bottomArea = new BottomArea();
    centerArea = new CenterArea();
    rightArea = new RightArea();
  }

  private void layoutControls() {
    this.setBottom(bottomArea);
    this.setCenter(centerArea);
    this.setRight(rightArea);
  }

  private void addTestData() {
    repository.add(new TaskData("A1", "A", State.DOING, LocalDate.parse("1990-02-03")));
    repository.add(new TaskData("A2", "B", State.TODO, LocalDate.parse("2001-08-21")));
    repository.add(new TaskData("A3", "C", State.DONE, LocalDate.parse("2030-09-30")));
    repository.add(new TaskData("B1", "D", State.DOING, LocalDate.parse("1990-02-03")));
    repository.add(new TaskData("B2", "E", State.TODO, LocalDate.parse("2001-08-21")));
    repository.add(new TaskData("B3", "F", State.DONE, LocalDate.parse("2030-09-30")));
    repository.add(new TaskData("C1", "G", State.DOING, LocalDate.parse("1990-09-30")));
    repository.add(new TaskData("C2", "H", State.TODO, LocalDate.parse("2001-08-21")));
    repository.add(new TaskData("C3", "I", State.DONE, LocalDate.parse("2030-09-30")));
    repository.add(new TaskData("X1", "Z", State.DOING, LocalDate.parse("1990-02-03")));
    repository.add(new TaskData("X2", "Y", State.TODO, LocalDate.parse("2001-08-21")));
    repository.add(new TaskData("X3", "Z", State.DONE, LocalDate.parse("2030-09-30")));
  }

}
