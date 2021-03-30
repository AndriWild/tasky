package tasky.java.ui;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tasky.java.command.AddCommand;
import tasky.java.command.DeleteCommand;
import tasky.java.command.FilterCommand;
import tasky.java.command.ShowCommand;
import tasky.java.command.UpdateCommand;
import tasky.java.command.UserCommand;
import tasky.java.model.State;
import tasky.java.model.TaskContainer;
import tasky.java.model.TaskData;
import tasky.java.model.TaskMap;

public final class CLI {

  private TaskContainer tasks;
  private final Map<String, UserCommand> strategyChooser;

  public CLI() {
    tasks = new TaskMap();
    strategyChooser = new HashMap<>();

    initCommands();
    printWelcomeText();

    addTestData();
  }

  public void run() {
    String userInput = "";
    do {
      userInput = QuestionHelper.ask(getStrategyNames().toLowerCase());
      UserCommand command = strategyChooser.get(userInput);
      if (command != null) {
        command.taskOperation(tasks);
      }
    } while (!userInput.equals("quit"));
  }

  private void initCommands() {
    strategyChooser.put("add", new AddCommand());
    strategyChooser.put("update", new UpdateCommand());
    strategyChooser.put("show", new ShowCommand());
    strategyChooser.put("delete", new DeleteCommand());
    strategyChooser.put("filter", new FilterCommand());
  }

  private String getStrategyNames() {
    String names = "";
    Set<String> set = strategyChooser.keySet();

    for (String string : set) {
      names += string;
      names += " | ";
    }
    names += "quit";
    return names;
  }

  private void printWelcomeText() {
    System.out.print("== Tasky ==\n");
  }

  private void addTestData() {
    // Test data
    tasks.add(new TaskData("A1", "A", State.DOING, LocalDate.parse("1990-02-03")));
    tasks.add(new TaskData("A2", "B", State.TODO, LocalDate.parse("2001-08-21")));
    tasks.add(new TaskData("A3", "C", State.DONE, LocalDate.parse("2030-09-30")));
    tasks.add(new TaskData("B1", "D", State.DOING, LocalDate.parse("1990-02-03")));
    tasks.add(new TaskData("B2", "E", State.TODO, LocalDate.parse("2001-08-21")));
    tasks.add(new TaskData("B3", "F", State.DONE, LocalDate.parse("2030-09-30")));
    tasks.add(new TaskData("C1", "G", State.DOING, LocalDate.parse("1990-09-30")));
    tasks.add(new TaskData("C2", "H", State.TODO, LocalDate.parse("2001-08-21")));
    tasks.add(new TaskData("C3", "I", State.DONE, LocalDate.parse("2030-09-30")));
    tasks.add(new TaskData("X1", "Z", State.DOING, LocalDate.parse("1990-02-03")));
    tasks.add(new TaskData("X2", "Y", State.TODO, LocalDate.parse("2001-08-21")));
    tasks.add(new TaskData("X3", "Z", State.DONE, LocalDate.parse("2030-09-30")));
  }
}
