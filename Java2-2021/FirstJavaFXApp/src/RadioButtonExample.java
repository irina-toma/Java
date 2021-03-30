import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ToggleGroup group = new ToggleGroup();

        RadioButton button1 = new RadioButton("Go out");
        button1.setToggleGroup(group);
        button1.setSelected(true);

        RadioButton button2 = new RadioButton("Stay home");
        button2.setToggleGroup(group);

        VBox layout = new VBox();
        layout.getChildren().addAll(button1, button2);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setTitle("Radio button example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
