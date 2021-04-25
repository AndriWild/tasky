package tasky.java.gui;

import java.util.Optional;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import tasky.java.model.Task;

public class Details {

  private LongProperty selectedTask;

  public Details(RightArea rightArea) {
    selectedTask = new SimpleLongProperty();
    selectedTask.addListener(change -> {
      ObservableList<Task> list = ApplicationUI.getRepository();
      Optional<Task> task = list.stream().filter(e -> e.getId() == selectedTask.get()).findAny();
      rightArea.updateTask(task.get());
    });
  }

  public LongProperty getIdProperty() {
    return selectedTask;
  }
}
