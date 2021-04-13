import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();

        ObservableList<String> months = FXCollections.observableArrayList(
                "Ianuarie", "Februarie", "Martie", "Aprilie",
                "Mai", "Iunie", "Iulie", "August", "Septembrie",
                "Octombrie", "Noiembrie", "Decembrie"
        );

        ComboBox comboBox = new ComboBox();
        comboBox.setItems(months);

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedItem = (String) comboBox.getSelectionModel().getSelectedItem();
                System.out.println(selectedItem);
            }
        });

        vbox.getChildren().addAll(comboBox);

        Scene scene = new Scene(vbox, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
