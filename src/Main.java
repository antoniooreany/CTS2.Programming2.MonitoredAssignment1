import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Group members : Andrei Martins, Anton Gorshkov, Josh Kornfeld

public class Main extends Application {
    // Initialize constants
    private static final double TOP_INSET = 0;
    private static final double RIGHT_INSET = 0;
    private static final double BOTTOM_INSET = 0;
    private static final double LEFT_INSET = 0;
    private static final int X_MAX = 16;
    private static final int Y_MAX = 16;
    private static final double H_GAP = 2;
    private static final double V_GAP = 2;
    private static final double PIXEL_WIDTH = 20;
    private static final double PIXEL_HEIGHT = 20;
    private static final Color INIT_COLOR = Color.WHITE;
    private static final Color PAINT_COLOR = Color.BLACK;

    // Override the start() method.
    public void start(Stage stage) {
        // Give the stage a title.
        stage.setTitle("Monitored Assignment1");
        // Create the GridPane.
        RootPane rootPane = new RootPane(X_MAX, Y_MAX, H_GAP, V_GAP, PIXEL_WIDTH, PIXEL_HEIGHT, INIT_COLOR, PAINT_COLOR);
        // Gaps at the outside borders
        rootPane.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));
        // Create a scene.
        Scene scene = new Scene(rootPane);
        // Handle a mouse press and drag event on the scene.
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, getMouseEventHandler(rootPane));
        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, getMouseEventHandler(rootPane));
        // Set the scene on the stage.
        stage.setScene(scene);
        // the size of the stage match the size of the scene
        stage.sizeToScene();
        // the size of the stage set as not resizable
        stage.setResizable(false);
        // Show the stage and its scene.
        stage.show();
    }

    // MouseEventHandler: events initialization for the left and right mouse buttons
    private EventHandler<MouseEvent> getMouseEventHandler(RootPane rootPane) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // in case of PRIMARY BUTTON - paint
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    rootPane.paint(mouseEvent);
                // in case of SECONDARY BUTTON - clear
                } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    rootPane.clearAll();
                }
            }
        };
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}