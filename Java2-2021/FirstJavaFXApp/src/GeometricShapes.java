import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GeometricShapes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        Rectangle rectangle = new Rectangle();
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.RED);


        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(0);
        rectangle2.setY(400);
        rectangle2.setWidth(100);
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.BLUE);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setX(400);
        rectangle3.setY(400);
        rectangle3.setWidth(100);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.YELLOW);


        Rectangle rectangle4 = new Rectangle();
        rectangle4.setX(400);
        rectangle4.setY(0);
        rectangle4.setWidth(100);
        rectangle4.setHeight(100);
        rectangle4.setFill(Color.GREEN);

        root.getChildren().add(rectangle);
        root.getChildren().add(rectangle2);
        root.getChildren().add(rectangle3);
        root.getChildren().add(rectangle4);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
