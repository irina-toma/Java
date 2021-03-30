import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        label.setText("Hello world!");

        Button button = new Button();
        button.setText("Click on me!");

        HBox group = new HBox();
        group.getChildren().addAll(label, button);

        Scene scene = new Scene(group, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
