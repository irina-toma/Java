import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageExample extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("puppy.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(25);

        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        imageView.setPreserveRatio(true);

        ColorAdjust colorAdjust = new ColorAdjust();

        colorAdjust.setContrast(0.1);
        colorAdjust.setHue(-0.05);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);

//        imageView.setEffect(colorAdjust);

        SepiaTone st = new SepiaTone();
        imageView.setEffect(st);

        Group root = new Group(imageView);

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("Puppy image");
        stage.setScene(scene);
        stage.show();
    }
}