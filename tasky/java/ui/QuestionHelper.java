package tasky.java.ui;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import tasky.java.model.State;

public final class QuestionHelper {

  private QuestionHelper() {
  }

  public static String ask(String quest) {
    InputStreamReader inputReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputReader);

    System.out.println(quest);
    String userInput = "";
    try {
      userInput = bufferedReader.readLine();
    } catch (IOException e) {
      System.err.println("Something went wrong by user input! " + e.getStackTrace());
    }
    return userInput;
  }

  public static LocalDate convertDate(String userInput) {
    if (!userInput.isEmpty()) {
      try {
        return LocalDate.parse(userInput);
      } catch (Exception e) {
        System.out.println("Date: Keine gültige Eingabe! Heutiges Datum eingefügt");
      }
    }
    return null;
  }

  public static State convertStatus(String userInput) {
    if (!userInput.isEmpty()) {
      try {
        return State.valueOf(userInput.toUpperCase());
      } catch (Exception e) {
        System.out.println("Status: Keine gültige Eingabe! Status auf Todo gesetzt.");
      }
    }
    return null;
  }
}
