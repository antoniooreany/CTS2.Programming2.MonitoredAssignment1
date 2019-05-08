import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int TOP_INSET = 0;
    private static final int RIGHT_INSET = 0;
    private static final int BOTTOM_INSET = 0;
    private static final int LEFT_INSET = 0;

    static int getTopInset() {
        return TOP_INSET;
    }

    static int getLeftInset() {
        return LEFT_INSET;
    }

    // Override the start() method.
    public void start(Stage myStage) {

        // Give the stage a title.
        myStage.setTitle("Monitored Assignment1");

        // Create the GridPane.
        RootPane root = new RootPane();
        // Gaps at the outside borders
        root.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));

        int sceneWidth = root.getPaneWidth();
        int sceneHeight = root.getPaneHeight();

        // Create a scene.
        Scene myScene = new Scene(root, sceneWidth, sceneHeight);

        // Handle a mouse click event on the scene.
        myScene.setOnMouseClicked(me -> {
            if (me.getButton() == MouseButton.PRIMARY) {
                root.paint(me, root);
            } else if (me.getButton() == MouseButton.SECONDARY) {
                root.clearAll();
            }
        });

        // Handle a mouse dragged event on the scene.
        myScene.setOnMouseDragged(me -> root.paint(me, root));

        // Set the scene on the stage.
        myStage.setScene(myScene);

        // Show the stage and its scene.
        myStage.show();
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
