package Pixel_Paint;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PixelPane extends Application {
	
	// gap between pixels.
	private static final int VGAP = 1; 
	private static final int HGAP = 1;
		
	//creation of the pixel canvas.
	private static final int PWIDTH = 16;
	private static final int PHEIGHT = 16;
	
	// width and height of the pixels
	private static final double RWIDTH = 24.0;
	private static final double RHEIGHT = 24.0;
	
    private static final Color INIT_COLOR = Color.WHITE;
    
    private static final double TOP_INSET = 10;
    private static final double RIGHT_INSET = 10;
    private static final double BOTTOM_INSET = 10;
    private static final double LEFT_INSET = 10;
    

    	
	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().  
		launch(args);
	}
	 
	public void start(Stage myStage) {
		myStage.setTitle("Pixel Paint");
      
	    // Create the HBox
	    HBox rootNode = new HBox(10);
		// Set border
        rootNode.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                BorderWidths.DEFAULT, new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET))));
		
        // create the grid pane and set in on the scene.
		GridPane grid = new GridPane();
        Scene myScene = new Scene(rootNode, rootNode.getMinWidth(), rootNode.getMinHeight());
        rootNode.getChildren().add(grid);
		
		myStage.setScene(myScene);
		myStage.sizeToScene();
		myStage.setResizable(false);
				
		grid.setVgap(VGAP); // gap between pixels.
		grid.setHgap(HGAP);
		
		
		//setting the size of the canvas and creating a pixel in each loop.
		for (int i = 0; i < PWIDTH; i++) {
			for (int j = 0; j< PHEIGHT;j++) {       		
				Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,INIT_COLOR);
				grid.add(rectangle, i, j);
			}		
		}
			
		// event handler to click.
		grid.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent me) {
				if (me.isPrimaryButtonDown()) {
					int x = (int) ((me.getX())/(RHEIGHT+HGAP));
					int y = (int) ((me.getY())/(RWIDTH+VGAP));
					Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.BLACK);
					grid.add(rectangle, x, y);
				}
				
			    //int col = (int) ((x + hgap/2 - LEFT_INSET) / (pixelWidth + hgap));
			    //int row = (int) ((y + vgap/2 - TOP_INSET) / (pixelHeight + vgap));
				
				//event handler to erase.
				else if (me.isSecondaryButtonDown()) {
					for (int i = 0; i < PWIDTH; i++) {
						for (int j = 0; j < PHEIGHT;j++) {       		
							Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.WHITE);
							grid.add(rectangle, i, j);

						}
					}					
				};
			}
		});
		
		//event handler to drag and draw.
		grid.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent me) {
				if (me.isPrimaryButtonDown()) {     
					int x = (int) ((me.getX())/(RHEIGHT+HGAP));
					int y = (int) ((me.getY())/(RWIDTH+VGAP));
					Rectangle rectangle = new Rectangle(RWIDTH,RHEIGHT,Color.BLACK);
					grid.add(rectangle, x, y); // x = column , y = row
					
				}
			}
		});
				
		myStage.show();		
	}
}


