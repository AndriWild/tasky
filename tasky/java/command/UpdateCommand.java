package tasky.java.command;

import java.time.LocalDate;

import tasky.java.model.State;
import tasky.java.model.TaskContainer;
import tasky.java.model.TaskData;
import tasky.java.ui.QuestionHelper;

public class UpdateCommand implements UserCommand {

  private String[] questions;
  private String[] answers;
  private static final int ID = 0;
  private static final int TITLE = 1;
  private static final int DESCRIPTION = 2;
  private static final int STATUS = 3;
  private static final int DATE = 4;

  public UpdateCommand() {
    questions = new String[] {"ID", "Title", "Beschreibung", "Status", "Datum"};
    answers = new String[questions.length];
  }

  @Override
  public void taskOperation(TaskContainer tasks) {

    for (int i = 0; i < questions.length; i++) {
      answers[i] = QuestionHelper.ask(questions[i]);
    }

    int id = Integer.parseInt(answers[ID]);
    answers[1] = answers[1].equals("") ? null : answers[TITLE];
    answers[2] = answers[2].equals("") ? null : answers[DESCRIPTION];

    State status = QuestionHelper.convertStatus(answers[STATUS]);
    LocalDate date = QuestionHelper.convertDate(answers[DATE]);

    tasks.update(id, new TaskData(answers[TITLE], answers[DESCRIPTION], status, date));
  }
}
