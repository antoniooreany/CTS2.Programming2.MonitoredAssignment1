import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PixelArt extends Application {

	private static final double RWIDTH = 24.0;
	private static final double RHEIGHT = 24.0;
	Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.BLACK);
	
	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().  
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("GridPane test2");
		GridPane grid = new GridPane();
		Scene myScene = new Scene(grid);
		myStage.setScene(myScene);
		myStage.sizeToScene();
		myStage.setResizable(false);
				
		grid.setVgap(1);
		grid.setHgap(1);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j< 16;j++) {       		
				Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.WHITE);
				grid.add(rectangle, i, j);
			}		
		}
		
		// Create a scene.  
		
		grid.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent me) {
				if (me.isPrimaryButtonDown()) {
					int x = (int) (me.getX()/(RHEIGHT+1));
					int y = (int) (me.getY()/(RWIDTH+1));
					Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.BLACK);
					grid.add(rectangle, x, y);
				}
			}
		});
		grid.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent me) {
				if (me.isPrimaryButtonDown()) {     
					int x = (int) (me.getX()/(RHEIGHT+1));
					int y = (int) (me.getY()/(RWIDTH+1));
					Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.BLACK);
					grid.add(rectangle, x, y); // x = column , y = row
					
				}
			}
		});
		grid.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				if (me.isSecondaryButtonDown()) {
					for (int i = 0; i < 16; i++) {
						for (int j = 0; j< 16;j++) {       		
							Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.WHITE);
							grid.add(rectangle, i, j);

						}
					}					
				}
			}
		});
		
		myStage.show();
		
	}
}

