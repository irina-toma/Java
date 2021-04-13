import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();

        ObservableList<String> months = FXCollections.observableArrayList(
                "Ianuarie", "Februarie", "Martie", "Aprilie",
                "Mai", "Iunie", "Iulie", "August", "Septembrie",
                "Octombrie", "Noiembrie", "Decembrie"
        );

        ListView<String> listView = new ListView<>(months);

        // multiple selection
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button b = new Button("View Selected");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
                System.out.println(selectedItems);
            }
        });

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
                System.out.println(selectedItems);
            }
        });

        vbox.getChildren().addAll(listView, b);

        Scene scene = new Scene(vbox, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
