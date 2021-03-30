import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CheckBox checkBox1= new CheckBox();
        checkBox1.setText("Apples");

        CheckBox checkBox2 = new CheckBox();
        checkBox2.setText("Pie crust");

        VBox layout = new VBox();
        layout.getChildren().addAll(checkBox1, checkBox2);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setTitle("Shopping list");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
