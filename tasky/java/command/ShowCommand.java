package tasky.java.command;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tasky.java.model.Task;
import tasky.java.model.TaskContainer;
import tasky.java.ui.QuestionHelper;

public class ShowCommand implements UserCommand {

  Map<String, Comparator<Task>> sortReference;

  public ShowCommand() {
    sortReference = new HashMap<>();
    sortReference.put("t", comparing(Task::getTitle));
    sortReference.put("d", comparing(Task::getDescription));
    sortReference.put("s", comparing(Task::getStatus));
    sortReference.put("z", comparing(Task::getDate).reversed());
  }

  @Override
  public void taskOperation(TaskContainer tasks) {
    List<Task> printList = tasks.get();
    String userInput = QuestionHelper.ask("Order By: t=title, d=description, s=status, z=date");
    Comparator<Task> comp = sortReference.get(userInput);
    printList.sort(comp);
    printList.forEach(System.out::println);
  }
}
