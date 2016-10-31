package kirasekiprince.build;

//Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Introduction {
	//Variable for which background should be displayed
	public static int count = 0;
	
	//Runs the introduction for the game/the beginning of the game
	public static void runGame(Stage stage) throws FileNotFoundException {
		
		//Allows input from the script for who's speaking for the introduction
		Scanner reader = new Scanner(new File("Scripts/intro.txt"));
		Scanner reader2 = new Scanner(new File("Scripts/names.txt"));
		
		//Creates StackPane and scene
		StackPane intro = new StackPane();
		Scene introduction = new Scene(intro, 1200, 750);
		
		//Creates an imageView for the dialogue
		ImageView dialogueBox = new ImageView();
		dialogueBox.setImage(new Image("file:Images/dialogueBox.png"));
		
		//Creates ImageViews for the various backgrounds in the scene
		ImageView star = new ImageView();
		star.setImage(new Image("file:Images/Backgrounds/shootingstar.jpg"));
		ImageView room = new ImageView();
		room.setImage(new Image("file:Images/Backgrounds/bedroom.jpg"));
		ImageView country = new ImageView();
		country.setImage(new Image("file:Images/Backgrounds/countryside1.jpg"));
		ImageView inside = new ImageView();
		inside.setImage(new Image("file:Images/Backgrounds/inside.jpg"));
		ImageView castle = new ImageView();
		castle.setImage(new Image("file:Images/Backgrounds/castle.jpg"));
		
		//Sets a key for when the background will switch
		String key = "bananya";
		//Creates a list of imageView, count is used to represent its index
		ImageView[] backgrounds = {room, star, country, inside, castle};
		
		//Creates a label for who is speaking, sets its font/location
		Label speaker = new Label(reader2.nextLine());
		speaker.setFont(Font.font("Calisto MT", FontWeight.BOLD, 24));
		speaker.setTextFill(Color.BLACK);
		speaker.setTranslateX(-435);
		speaker.setTranslateY(105);
		
		/*
		 * Creates a label for the dialogue, sets its font/location, reads from a text file to get its display
		 * Uses fits from class Methods in order to make sure the dialogue doesn't go out of its boundaries
		 */
		Label dialogue = new Label(Methods.fit(reader.nextLine(), 80), dialogueBox);
		dialogue.setFont(Font.font("Calisto MT", FontWeight.BOLD, 24));
		dialogue.setTextFill(Color.WHITE);
		dialogue.setTextAlignment(TextAlignment.LEFT);
		dialogue.setContentDisplay(ContentDisplay.CENTER);
		dialogue.setTranslateY(215);
		dialogue.setWrapText(true);
	
		//Changes text when dialogue box is clicked
		dialogue.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override	
			public void handle(MouseEvent e) {
				if (reader.hasNextLine()) {
					String toDisplay = reader.nextLine();
					/*
					 * If the line is equal to the key and count isn't longer than the length of the list of backgrounds
					 */
					if ((toDisplay.equals(key)) && (count != backgrounds.length-1)) {
						//Increments count and adds the new background (has to clear all first as the order matters for StackPane)
						count++;
						intro.getChildren().clear();
						intro.getChildren().addAll(backgrounds[count], dialogue, speaker);
						//Goes to next line as to not display the key
						if (reader.hasNextLine()) {
							toDisplay = reader.nextLine();
						}
					}
					//Displays the next line of dialogue
					dialogue.setText(Methods.fit(toDisplay, 80));
				}
				//Displays the next speaker
				if (reader2.hasNextLine()) {
					speaker.setText(reader2.nextLine());
				}
			}
		});
		
		//Adds the first background, the dialogue, and the speaker label to the StackPane and sets the stage to the scene
		intro.getChildren().addAll(room, dialogue, speaker);
		stage.setScene(introduction);
	}
}
