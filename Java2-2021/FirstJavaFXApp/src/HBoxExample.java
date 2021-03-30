import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class HBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label label1 = new Label("Hello");
        label1.setTextFill(Color.BLUE);
        Label label2  = new Label("Buna");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label1, label2);

        Scene scene = new Scene(hBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
