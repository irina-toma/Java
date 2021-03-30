import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Click me!");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Clicked on button");
            }
        });

        VBox layout = new VBox();
        layout.getChildren().add(btn);

        Scene scene = new Scene(layout, 300, 300);

        primaryStage.setTitle("My first button");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
