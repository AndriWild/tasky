package tasky.java.command;

import tasky.java.model.TaskContainer;

@FunctionalInterface
public interface UserCommand {

  public void taskOperation(TaskContainer tasks);

}
