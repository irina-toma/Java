package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridCount extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: white;");
		int nrRows = 3;
		int nrCols = 4;
		
		for (int row = 0; row < nrRows; row ++) {
			int col = 0;
			for (col = 0; col < nrCols; col ++) {
				Label label = new Label("" + (col + 1));
				label.setStyle("-fx-border-color: green; -fx-border-width: 1; -fx-font-size: 20");
				label.setPadding(new Insets(40));
				root.add(label, col, row);
			}
			Label label = new Label("0");
			label.setPadding(new Insets(40));
			label.setStyle("-fx-border-color: blue; -fx-border-width: 1; -fx-font-size: 20");
			root.add(label, col + 1, row);
		}
		
		root.setOnMouseClicked(event -> {
			System.out.println(event);
			if (event.getTarget() instanceof Label) {
				Label target = (Label) event.getTarget();
				GridPane source = (GridPane) event.getSource();
				int rowIndex = GridPane.getRowIndex(target);
				int columnIndex = nrCols;
				String text = target.getText();
				
				ObservableList<Node> allChildren = source.getChildren();
				
				Label lastLabel = (Label) allChildren.get(rowIndex * (nrCols + 1) + nrCols);
				String initialSum = lastLabel.getText();
				
				lastLabel.setText((Integer.parseInt(text) + Integer.parseInt(initialSum))+ "");
				
			} else if (event.getTarget() instanceof Text) {
				Text target = (Text) event.getTarget();
			}
		});
		
		
		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
