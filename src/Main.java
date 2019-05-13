import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    public void start(Stage myStage) {
        // Give the stage a title.
        myStage.setTitle("Monitored Assignment1");
        // Create the GridPane.
        RootPane root = new RootPane(X_MAX, Y_MAX, H_GAP, V_GAP, PIXEL_WIDTH, PIXEL_HEIGHT, INIT_COLOR, PAINT_COLOR);
        // Gaps at the outside borders
        root.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));
        // Create a scene.
        Scene myScene = new Scene(root);
        // Handle a mouse click event on the scene.
        myScene.setOnMouseClicked(me -> {
            if (me.getButton() == MouseButton.PRIMARY) {
                root.paint(me);
            } else if (me.getButton() == MouseButton.SECONDARY) {
                root.clearAll();
            }
        });
        // Handle a mouse dragged event on the scene.
        myScene.setOnMouseDragged(me -> root.paint(me));
        // Set the scene on the stage.
        myStage.setScene(myScene);
        // Show the stage and its scene.
        myStage.sizeToScene();
        myStage.setResizable(false);
        myStage.show();
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
