import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BorderPaneExample  extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();

        HBox toolbar = new HBox(8);
        HBox statusbar = new HBox(8);
        VBox content = new VBox(8);
        VBox left = new VBox(8);
        VBox right = new VBox(8);

        toolbar.getChildren().addAll(
                new Rectangle(20, 20, Color.YELLOW),
                new Rectangle(20, 20, Color.GREEN),
                new Rectangle(20, 20, Color.RED)
        );

        statusbar.getChildren().addAll(
                new Circle(20, 20, 10, Color.YELLOW),
                new Circle(20, 20, 10, Color.GREEN),
                new Circle(20, 20, 10,Color.RED)
        );

        HBox hbName = new HBox(8);
        hbName.getChildren().addAll(
                new Label("Name: "),
                new TextField()
        );

        HBox hbAge = new HBox(8);
        hbAge.getChildren().addAll(
                new Label("Age: "),
                new TextField()
        );

        content.getChildren().addAll(hbName, hbAge);
        content.setPadding(new Insets(50, 50, 50, 50));

        left.getChildren().addAll(
                new Label("Link 1"),
                new Label("Link 2")
        );

        right.getChildren().addAll(
                new Button("Button 1"),
                new Button("Button 2")
        );

        borderPane.setTop(toolbar);
        borderPane.setCenter(content);
        borderPane.setBottom(statusbar);
        borderPane.setLeft(left);
        borderPane.setRight(right);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
