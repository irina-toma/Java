package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Spanzuratoarea extends Application{

	ArrayList<String> wordList;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setWordList();
		String word = pickRandomWord();
		
		VBox container = new VBox();
		
		Group hangman = createHangman();
		
		HBox letters = createLetters(word);
		
		Label l = new Label("Introduceti cate o litera");
		TextField tf = new TextField();
		
		play(tf, word, hangman, letters);
		
		container.getChildren().addAll(hangman, letters, l, tf);

		Scene scene = new Scene(container, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void setWordList() {
		this.wordList = new ArrayList<String>();
		this.wordList.add("CALCULATOR");
		this.wordList.add("INSPECTORAT");
		this.wordList.add("ARIE");
		this.wordList.add("CANAR");
		this.wordList.add("CREION");
	}
	
	private String pickRandomWord() {
		Random random = new Random();
		int index = random.nextInt(this.wordList.size());
		return this.wordList.get(index);
	}

	private HBox createLetters(String word) {
		HBox hb = new HBox();
		char first = word.charAt(0);
		char last = word.charAt(word.length() - 1);
		
		hb.getChildren().add(new Label("" + first));
		
		
		for (int i = 1; i < word.length() - 1; i ++) {
			hb.getChildren().add(new Label("_ "));
		}
		
		hb.getChildren().add(new Label("" + last));
		
		return hb;
	}

	private Group createHangman() {
		Group group = new Group();
		
		Path hang = new Path();
		MoveTo mt = new MoveTo(200, 100);
		LineTo lt1 = new LineTo(200, 50);
		LineTo lt2 = new LineTo(100, 50);
		LineTo lt3 = new LineTo(100, 300);
		LineTo lt4 = new LineTo(50, 350);
		LineTo lt5 = new LineTo(150, 350);
		LineTo lt6 = new LineTo(100, 300);

		hang.getElements().addAll(mt, lt1, lt2, lt3, lt4, lt5, lt6);
		group.getChildren().add(hang);

		Line body = new Line(200, 100, 200, 200);
		group.getChildren().add(body);

		Circle head = new Circle(200, 100, 20);
		group.getChildren().add(head);

		Line armLeft = new Line(150, 100, 200, 150);
		group.getChildren().add(armLeft);

		Line armRight = new Line(250, 100, 200, 150);
		group.getChildren().add(armRight);

		Line legLeft = new Line(200, 200, 150, 250);
		group.getChildren().add(legLeft);

		Line legRight = new Line(200, 200, 250, 250);
		group.getChildren().add(legRight);

		return group;
	}
	
	private void play(TextField tf, String word, Group hangman, HBox wordLetters) {
		tf.setOnKeyTyped(event -> {
			boolean foundLetter = false;
			String letter = event.getCharacter();
			System.out.println(letter);
			
			char[] letters = word.toCharArray();
			for (int i = 0; i < letters.length; i ++) {
				String l = "" + letters[i];
				if (l.toLowerCase().equals(letter.toLowerCase())) {
					Label label = (Label) wordLetters.getChildren().get(i);
					label.setText(l + " ");
					foundLetter = true;
				}
			}
			
			if (!foundLetter) {
				hangman.getChildren().remove(hangman.getChildren().size() - 1);
			}
			
			checkScore(hangman, wordLetters);
		});
	}

	private void checkScore(Group hangman, HBox wordLetters) {
		Alert alert = new Alert(AlertType.INFORMATION);
		if (hangman.getChildren().size() == 1) {
			alert.setTitle("Scor");
			alert.setHeaderText("Ai pierdut!");
			alert.setContentText("Ne pare foarte rau :(");

			alert.showAndWait();
		}
	}
	
	// comentariu grupa 2 java

}
