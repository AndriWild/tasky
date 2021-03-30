package tasky.java.command;

import java.util.stream.Collectors;
import tasky.java.model.State;
import tasky.java.model.TaskContainer;
import tasky.java.ui.QuestionHelper;

public class FilterCommand implements UserCommand {

  @Override
  public void taskOperation(TaskContainer tasks) {
    String userInput = QuestionHelper.ask(getFormattetStateNames()).toUpperCase();
    State state = QuestionHelper.convertStatus(userInput);

    tasks.get().stream().filter(task -> task.getStatus() == state).collect(Collectors.toList())
        .forEach(System.out::println);
  }

  private String getFormattetStateNames() {
    String formattetStateNames = "";
    State[] stateNames = State.values();
    for (State state : stateNames) {
      formattetStateNames += state.toString();
      formattetStateNames += " | ";
    }
    return formattetStateNames;
  }

}
