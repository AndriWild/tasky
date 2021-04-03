package tasky.java.gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import tasky.java.model.State;

public class RightArea extends GridPane {

  Label[] labels;
  Node[] inputFields;

  DatePicker datePicker;

  HBox buttonRow;
  Button btnSave;
  Button btnDelete;

  public RightArea() {
    this.setGridLinesVisible(false);
    this.setPadding(new Insets(50));
    this.setVgap(20);
    this.setHgap(10);
    this.setPrefWidth(400);
    initializeControls();
    layoutControls();
  }

  public void initializeControls() {
    labels = new Label[ControlNames.values().length];
    inputFields = new Node[ControlNames.values().length];

    for (ControlNames name : ControlNames.values()) {
      labels[name.index] = new Label(name.name);
    }

    inputFields[ControlNames.ID.index] = new TextField();
    inputFields[ControlNames.TITLE.index] = new TextField();
    inputFields[ControlNames.DESCRIPTION.index] = new TextArea();
    inputFields[ControlNames.DATE.index] = new DatePicker();
    inputFields[ControlNames.STATE.index] =
        new ChoiceBox<>(FXCollections.observableArrayList(State.values()));

    btnSave = new Button("Save");
    btnDelete = new Button("Delete");
    buttonRow = new HBox(btnSave, btnDelete);
    buttonRow.setPadding(new Insets(10, 10, 10, 0));
    buttonRow.setSpacing(20);

  }

  public void layoutControls() {
    addColumn(0, labels);
    addColumn(1, inputFields);
    add(buttonRow, 0, 5, 2, 1);
  }

}
