package tasky.java.model;

import java.time.LocalDate;

public class Task {

  public static Object getData;
  private int id;
  private TaskData data;

  public Task(int id, TaskData data) {
    this.id = id;
    this.data = data;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return data.getTitle();
  }

  public String getDescription() {
    return data.getDescription();
  }

  public State getStatus() {
    return data.getStatus();
  }

  public LocalDate getDate() {
    return data.getDate();
  }

  public void setTitle(String title) {
    data.setTitle(title);
  }

  public void setDescription(String description) {
    data.setDescription(description);
  }

  public void setStatus(State status) {
    data.setStatus(status);
  }

  public void setDate(LocalDate date) {
    data.setDate(date);
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Task) {
      Task task = (Task) that;
      return this.id == task.id && this.data == task.data;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = id;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "[ID:" + this.id + "]" + "\tTitle: " + data.getTitle() + "\tDescription: "
        + data.getDescription() + "\tStatus: " + data.getStatus().toString().toLowerCase()
        + "\tFällig am: " + data.getDate().toString();
  }

}
