// Demonstrate a simple scene graph that contains a label. 

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

public class SimpleSceneGraphDemo extends Application {

	public static void main(String[] args) {

		// Start the JavaFX application by calling launch(). 
		launch(args);
	}

	// Override the start() method. 
	public void start(Stage myStage) {

		// Give the stage a title. 
		myStage.setTitle("Demonstrate A Simple Scene Graph");

		// Use a FlowPane for the root node. 
		FlowPane rootNode = new FlowPane();

		// Create a scene. 
		Scene myScene = new Scene(rootNode, 300, 200);

		// Set the scene on the stage. 
		myStage.setScene(myScene);

		// Create a label. 
		Label myLabel = new Label("A simple JavaFX label.");
		myLabel.setTextFill(Color.DARKBLUE);


		// Add the label to the scene graph. 
		rootNode.getChildren().add(myLabel);
		// getChildren() gives a handle to all the children of the rootNode

		// Show the stage and its scene. 
		myStage.show();
	}
}