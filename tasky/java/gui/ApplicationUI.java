package tasky.java.gui;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class ApplicationUI extends BorderPane {

  BottomArea bottomArea;
  CenterArea centerArea;
  RightArea rightArea;

  public ApplicationUI() {
    this.setPadding(new Insets(20));
    initializeControls();

    layoutControls();
  }

  private void initializeControls() {
    bottomArea = new BottomArea();
    centerArea = new CenterArea();
    rightArea = new RightArea();
  }

  private void layoutControls() {
    this.setBottom(bottomArea);
    this.setCenter(centerArea);
    this.setRight(rightArea);
  }
}
