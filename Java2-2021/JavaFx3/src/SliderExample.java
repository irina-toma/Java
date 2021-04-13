import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderExample extends Application {

    public void start(Stage stage) {

        Label label = new Label("Select value");
        Label l = new Label(" ");

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(80);

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.setBlockIncrement(10);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    public void changed(ObservableValue<? extends Number>
                                                observable, Number oldValue, Number newValue) {
                        l.setText("value: " + newValue);
                    }
                });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, slider, l);
        Scene scene = new Scene(vbox, 350, 200);
        stage.setScene(scene);
        stage.show();
    }
}