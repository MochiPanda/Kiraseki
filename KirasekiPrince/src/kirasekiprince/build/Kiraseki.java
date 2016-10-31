package kirasekiprince.build;

//Imports
import java.io.FileNotFoundException;
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
import javafx.stage.Stage;

public class Kiraseki extends Application {
	
	//Displays the main menu - new game, load game, instructions, quit
	public void start(Stage stage) {
		//Creates two StackPanes - one for the menu and one for 
		StackPane menu = new StackPane();
		StackPane help = new StackPane();
		
		//Creates two scenes - one for the main menu and one for the instructions, 1200x750 display
		Scene main = new Scene(menu, 1200, 750);
		Scene guide = new Scene(help, 1200, 750);
		
		//Sets up background for main menu (logo, castle, and cats)
		ImageView mainmenu = new ImageView();
		mainmenu.setImage(new Image("file:Images/Backgrounds/kirasekimainmenu.png"));
		//Sets up background (stars)
		ImageView bg = new ImageView();
		bg.setImage(new Image("file:Images/Backgrounds/kirasekimainmenubackground.png"));
		//Sets up blue box for button backgrounds
		ImageView buttons = new ImageView();
		buttons.setImage(new Image("file:Images/bkg-sel.png"));
		
		//New Game button - moves to bottom left of screen, sets fonts
		Label newGame = new Label("New Game");
		newGame.setTranslateX(-400);
		newGame.setTranslateY(50);
		newGame.setFont(Font.font("Century Gothic", FontWeight.BOLD, 24));
		newGame.setTextFill(Color.WHITE);
		newGame.setContentDisplay(ContentDisplay.CENTER);
		
		//When clicked, starts running the game (in Introduction class)
		newGame.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) { 
				try {
					Introduction.runGame(stage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//When mouse scrolls over label, background appears, disappears when mouse not over label
		newGame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				newGame.setGraphic(buttons);
			}
		});
		newGame.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				newGame.setGraphic(null);
			}
		});
		
		//Load Game button - moves to bottom left of screen, sets fonts
		Label loadGame = new Label("Load");
		loadGame.setTranslateX(-400);
		loadGame.setTranslateY(110);
		loadGame.setFont(Font.font("Century Gothic", FontWeight.BOLD, 24));
		loadGame.setTextFill(Color.WHITE);
		loadGame.setContentDisplay(ContentDisplay.CENTER);
		
		//Will eventually load a new game - not complete
		/*loadGame.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override	
			public void handle(MouseEvent e) { 
			}
		}); */
		
		//When mouse scrolls over label, background appears, disappears when mouse not over label
		loadGame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				loadGame.setGraphic(buttons);
			}
		});
		loadGame.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				loadGame.setGraphic(null);
			}
		});
		
		//Instructions button - moves to bottom left of screen, sets fonts
		Label instructions = new Label("Instructions");
		instructions.setTranslateX(-400);
		instructions.setTranslateY(170);
		instructions.setFont(Font.font("Century Gothic", FontWeight.BOLD, 24));
		instructions.setTextFill(Color.WHITE);
		instructions.setContentDisplay(ContentDisplay.CENTER);
		
		//Changes scene when clicked to screen displaying instructions
		instructions.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override	
			public void handle(MouseEvent e) {
				stage.setScene(guide);
			}
		});
		
		//When mouse scrolls over label, background appears, disappears when mouse not over label
		instructions.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				instructions.setGraphic(buttons);
			}
		});
		instructions.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				instructions.setGraphic(null);
			}
		});
		
		//Back button - moves to bottom right of screen, sets fonts
		Label back = new Label("Back");
		back.setTranslateX(560);
		back.setTranslateY(215);
		back.setFont(Font.font("Century Gothic", FontWeight.BOLD, 24));
		back.setTextFill(Color.WHITE);
		back.setContentDisplay(ContentDisplay.CENTER);
		
		//Changes back to main menu screen from instructions when clicked
		back.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override	
			public void handle(MouseEvent e) {
				stage.setScene(main);
			}
		});
		
		//When mouse scrolls over label, background appears, disappears when mouse not over label
		back.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				back.setGraphic(buttons);
			}
		});
		back.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				back.setGraphic(null);
			}
		});
				
		//Quit button - moves to bottom right of screen, sets fonts
		Label quit = new Label("Quit");
		quit.setTranslateX(-400);
		quit.setTranslateY(230);
		quit.setFont(Font.font("Century Gothic", FontWeight.BOLD, 24));
		quit.setTextFill(Color.WHITE);
		quit.setContentDisplay(ContentDisplay.CENTER);
		
		//When clicked, screen closes
		quit.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override	
			public void handle(MouseEvent e) {
				stage.close();
			}
		});
		
		//When mouse scrolls over label, background appears, disappears when mouse not over label
		quit.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				quit.setGraphic(buttons);
			}
		});
		quit.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				quit.setGraphic(null);
			}
		});
		
		//Adds the background and buttons to the main menu 
		menu.getChildren().addAll(mainmenu, newGame, loadGame, instructions, quit);
		
		//Adds the background and back button for the instructions 
		help.getChildren().addAll(bg, back);
		
		//Initially sets the stage to display the main menu and shows it
		stage.setScene(main);
		stage.show();
	
	}
	
	//Runs the game
	public static void main(String[] args) {
		Application.launch(args);
	}
}
