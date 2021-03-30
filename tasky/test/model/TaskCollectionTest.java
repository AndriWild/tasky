package tasky.test.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.time.LocalDate;
import tasky.java.model.State;
import tasky.java.model.Task;
import tasky.java.model.TaskContainer;
import tasky.java.model.TaskData;
import tasky.java.model.TaskMap;

public class TaskCollectionTest {
  TaskContainer data;
  TaskData task1;
  TaskData task2;
  TaskData task3;

  @Before
  public void initialize() {
    data = new TaskMap();
    task1 = new TaskData("Title 1", "Description 1", State.DOING, LocalDate.now());
    task2 = new TaskData("Title 2", "Description 2", State.DOING, LocalDate.now());
    task3 = new TaskData("Title 3", "Description 3", State.DOING, LocalDate.now());
  }

  @Test
  public void nullTest() {

    data.add(task1);
    data.delete(1);
    Task t1 = data.get(3);
    assertNull(t1);


    data.add(task2);
    data.delete(2);
    data.add(task3);
    data.delete(3);
    Task t2 = data.get(3);
    assertNull(t2);

  }

  @Test
  public void statusTest() {
    int id = 1;

    data.add(task1);
    assertEquals(State.TODO, task1.getStatus());
    data.update(id, new TaskData("", "", State.DOING, LocalDate.now()));
    assertEquals(State.DOING, task1.getStatus());
    data.update(id, new TaskData("", "", State.DONE, LocalDate.now()));
    assertEquals(State.DONE, task1.getStatus());
  }

  @Test
  public void sizeTest() {

    data.add(task1);
    data.add(task1);
    assertEquals(2, data.get().size());
    data.delete(1);
    assertEquals(1, data.get().size());
    data.delete(2);
    assertEquals(0, data.get().size());
  }

  @Test
  public void getTest() {

    data.add(task1);
    data.add(task2);

    assertEquals(task1, data.get(1));
    assertEquals(task2, data.get(2));
  }
}
