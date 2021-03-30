package tasky.java.command;

import tasky.java.model.TaskContainer;
import tasky.java.ui.QuestionHelper;

public class DeleteCommand implements UserCommand {

  @Override
  public void taskOperation(TaskContainer tasks) {

    String answer = QuestionHelper.ask("id");
    int id = Integer.parseInt(answer);
    tasks.delete(id);
  }

}
