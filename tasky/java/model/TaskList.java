package tasky.java.model;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements TaskContainer {

  private List<Task> tasks = new ArrayList<>();
  private int idCounter = 1;

  @Override
  public void add(TaskData taskData) {
    tasks.add(new Task(taskData));
  }

  @Override
  public void delete(int id) {
    tasks.removeIf((task) -> id == task.getId());
  }

  @Override
  public Task get(int id) {
    for (Task task : tasks) {
      if (task.getId() == id)
        return task;
    }
    return null;
  }

  @Override
  public void update(int id, TaskData data) {
    Task task = this.get(id);

    if (task != null) {

      task.setTitle(data.getTitle());

      task.setDescription(data.getDescription());

      task.setDate(data.getDate());

      task.setStatus(data.getStatus());
    }
  }

  @Override
  public List<Task> get() {
    return tasks;
  }

}
