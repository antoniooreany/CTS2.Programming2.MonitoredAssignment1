import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Group members : Andrei Martins, Anton Gorshkov, Josh Kornfeld

public class MonitoredAssignment1 extends Application {
    // Width of square
    private static final double RWIDTH = 24.0;
    // Height of square
    private static final double RHEIGHT = 24.0;
    // Create white square
    // TODO Don't need to create the object here
    // TODO Variable "rectangle" is never used, so creating of the new Rectangle is redundant here
    private Rectangle rectangle = new Rectangle(RWIDTH, RHEIGHT, Color.WHITE);
    // Create Gridpane
    // TODO Access should be private
    GridPane grid = new GridPane();

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().
        launch(args);
    }

    public void start(Stage myStage) {

        // Create a scene.
        myStage.setTitle("Monitored Assignment 1");
        Scene myScene = new Scene(grid);
        myStage.setScene(myScene);
        myStage.sizeToScene();
        myStage.setResizable(false);

        // Set gap around each square to 1 pixel
        // TODO gaps should be put into constants, not to hardcode
        grid.setVgap(1);
        grid.setHgap(1);

        createGrid();

        // Handle mouse left-click. Click turns square black
        grid.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            // TODO Duplicate code. Put into the method
            public void handle(MouseEvent me) {
                if (me.isPrimaryButtonDown()) {
                    // x & y get casted to integer because method add accepts integer values
                    // TODO Name variables x, y - column, row
                    int x = (int) (me.getX() / (RHEIGHT + 1)); // Calculates column of square that gets clicked
                    int y = (int) (me.getY() / (RWIDTH + 1)); // Calculates row of square that gets clicked
                    // TODO Initial color should be put into constants, not to hardcode
                    Rectangle rectangle = new Rectangle(RWIDTH, RHEIGHT, Color.BLACK);
                    // TODO When the mouse is out of the "grid", the Exceptions are generated. It should be solved.
                    grid.add(rectangle, x, y); // Adds a new black square in place of old white one.
                }
            }
        });

        // Handle mouse drag. Drag turns squares black
        grid.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            // TODO Duplicate code. Put into the method
            public void handle(MouseEvent me) {
                if (me.isPrimaryButtonDown()) {
                    // x & y get casted to integer because method add accepts integer values
                    // TODO Name variables x, y - column, row
                    int x = (int) (me.getX() / (RHEIGHT + 1)); // Calculates column of square that gets clicked
                    int y = (int) (me.getY() / (RWIDTH + 1)); // Calculates row of square that gets clicked
                    // TODO Fill color should be put into constants, not to hardcode
                    Rectangle rectangle = new Rectangle(RWIDTH, RHEIGHT, Color.BLACK);
                    // TODO When the mouse is out of the "grid", the Exceptions are generated. It should be solved.
                    grid.add(rectangle, x, y); // Adds a new black square in place of old white one.
                }
            }
        });

        // Handle mouse right-click. Click resets the grid turning all squares white
        grid.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (me.isSecondaryButtonDown()) {
                    createGrid();
                }
            }
        });

        myStage.show();

    }

    // Set up the grid of squares (16x16)
    // TODO Access could be private
    public void createGrid() {
        // TODO Name variables i, j - column, row
        // TODO The constants "16", "16" should be moved into the constants of the class for flexibility increasing
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                // Make the square white so it is initially invisible
                // TODO Initial color should be put into constants, not to hardcode
                Rectangle rectangle = new Rectangle(RWIDTH, RHEIGHT, Color.WHITE);
                grid.add(rectangle, i, j);

            }
        }
    }
}