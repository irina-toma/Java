import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.AbstractMap;
import java.util.Map;

public class MenuExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuBar mb = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu settingsMenu = new Menu("Settings");
        mb.getMenus().addAll(fileMenu, settingsMenu);

        MenuItem openMItem = new MenuItem("Open");
        Menu editMenu = new Menu("Edit");
        Menu saveMenu = new Menu("Save");

        MenuItem editCutMI = new MenuItem("Cut");
        MenuItem editCopyMI = new MenuItem("Copy");
        MenuItem editPasteMI = new MenuItem("Paste");
        editMenu.getItems().addAll(editCutMI, editCopyMI, editPasteMI);

        MenuItem saveAsMI = new MenuItem("Save As...");
        MenuItem saveAllMI = new MenuItem("Save All");
        saveMenu.getItems().addAll(saveAsMI, saveAllMI);

        fileMenu.getItems().addAll(openMItem, editMenu, saveMenu);

        MenuItem settingsProjectMI = new MenuItem("Project");
        MenuItem settingsGlobalMI = new MenuItem("Workspace");
        MenuItem helpMI = new MenuItem("Help");

        settingsMenu.getItems().addAll(settingsGlobalMI, settingsProjectMI, helpMI);

        Label l = new Label("no menu item selected");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l.setText(((MenuItem)e.getSource()).getText() + " selected");
            }
        };

        openMItem.setOnAction(event);
        editMenu.setOnAction(event);
        saveAsMI.setOnAction(event);

        VBox vb = new VBox(mb, l);

        Scene sc = new Scene(vb, 500, 300);
        primaryStage.setTitle("Menu Example");
        primaryStage.setScene(sc);

        primaryStage.show();

    }
}
