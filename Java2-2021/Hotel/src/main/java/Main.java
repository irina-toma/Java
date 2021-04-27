import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("login.fxml"));
        primaryStage.setTitle("Hotel");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }
}
