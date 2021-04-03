package tasky.java.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BottomArea extends HBox {

  HBox buttonRow;
  private Button btnNew;
  private Button btnRefresh;

  public BottomArea() {
    this.setPadding(new Insets(10));

    initializeControls();

    layoutControls();
  }

  private void initializeControls() {
    btnNew = new Button("New");
    btnRefresh = new Button("Refresh");
    buttonRow = new HBox(btnNew, btnRefresh);
    buttonRow.setSpacing(20);
    buttonRow.setPadding(new Insets(10, 10, 10, 0));
  }

  private void layoutControls() {
    this.getChildren().add(buttonRow);
  }

}
