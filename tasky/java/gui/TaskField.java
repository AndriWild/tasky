package tasky.java.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;

public class TaskField extends FlowPane {
  private static final int TASKFIELD_HEIGHT = Integer.MAX_VALUE;
  private static final int TASKFIELD_WIDTH = Integer.MAX_VALUE;
  private static final int REGION_HEIGHT = 150;
  private static final int REGION_WIDTH = 150;

  List<Region> regions;


  public TaskField(String color) {
    this.setStyle("-fx-background-color: #" + color + ";");
    this.setPrefHeight(TASKFIELD_HEIGHT);
    this.setPrefWidth(TASKFIELD_WIDTH);
    this.setHgap(10);
    this.setVgap(10);
    this.setPadding(new Insets(5));
    initializeControls();
    layoutControls();
  }

  private void initializeControls() {
    regions = new ArrayList<>();
    Stream.iterate(new Region(), n -> new Region()).limit(10).forEach(region -> {
      region = new Region();
      region.setPrefHeight(REGION_HEIGHT);
      region.setPrefWidth(REGION_WIDTH);
      region.setStyle("-fx-background-color: LIGHTGREY;");
      regions.add(region);
    });
  }

  private void layoutControls() {
    this.getChildren().addAll(regions);
  }
}
