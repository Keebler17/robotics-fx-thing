package io.github.keebler17.roboticsgfx;

import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	int x = 0;
	int y = 0;
	Group root = new Group();

	@Override
	public void start(Stage primaryStage) throws Exception {
		FileInputStream input = null;
		try {
			input = new FileInputStream("C:\\GFX\\field.png");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		
		VBox vBox = new VBox(imageView);
		Scene scene = new Scene(root);
				
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				root.getChildren().clear();
				root.getChildren().add(new Circle(100, 100, 5));
			}
			
		}));
	}

}
