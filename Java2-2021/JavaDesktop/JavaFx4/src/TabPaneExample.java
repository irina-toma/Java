import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TabPaneExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        TabPane tabPane = new TabPane();

        Tab tabCalatori = new Tab();
        tabCalatori.setText("Date calatori");
        tabCalatori.setContent(new Rectangle(200,200, Color.DARKVIOLET));
        tabPane.getTabs().add(tabCalatori);

        Tab tabRezervari = new Tab();
        tabRezervari.setText("Rezervari");
        tabRezervari.setContent(new Circle(200,200, 100, Color.CORAL));
        tabPane.getTabs().add(tabRezervari);

        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("TabPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
