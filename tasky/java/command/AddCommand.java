package tasky.java.command;

import java.time.LocalDate;

import tasky.java.model.State;
import tasky.java.model.TaskContainer;
import tasky.java.model.TaskData;
import tasky.java.ui.QuestionHelper;

public class AddCommand implements UserCommand {

  private String[] questions;
  private String[] answers;
  private static final int TITLE = 0;
  private static final int DESCRIPTION = 1;
  private static final int STATUS = 2;
  private static final int DATE = 3;

  public AddCommand() {
    questions = new String[] {"Title", "Description", "Status", "Date (YYYY-MM-DD)"};
    answers = new String[questions.length];
  }

  @Override
  public void taskOperation(TaskContainer tasks) {

    for (int i = 0; i < questions.length; i++) {
      answers[i] = QuestionHelper.ask(questions[i]);
    }

    State status = QuestionHelper.convertStatus(answers[STATUS]);
    if (status == null)
      status = State.TODO;

    LocalDate date = QuestionHelper.convertDate(answers[DATE]);
    if (date == null)
      date = LocalDate.now();

    tasks.add(new TaskData(answers[TITLE], answers[DESCRIPTION], status, date));
  }
}
