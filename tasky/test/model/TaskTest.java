package ch.fhnw.oop2.ub.tasky.test.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ch.fhnw.oop2.ub.tasky.java.model.State;
import ch.fhnw.oop2.ub.tasky.java.model.Task;
import ch.fhnw.oop2.ub.tasky.java.model.TaskData;

public class TaskTest {

  Task task;

  @Before
  public void initialize() {
    task = new Task(1, new TaskData("title", "description", State.DOING, LocalDate.now()));
  }

  @Test
  public void statusTest() {

    assertEquals(State.TODO, task.getStatus());
    task.setStatus(State.DOING);
    assertEquals(State.DOING, task.getStatus());
    task.setStatus(State.DONE);
    assertEquals(State.DONE, task.getStatus());

  }
}
