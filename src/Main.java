import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int TOP_INSET = 0;
    private static final int RIGHT_INSET = 0;
    private static final int BOTTOM_INSET = 0;
    private static final int LEFT_INSET = 0;

    // Override the start() method.
    public void start(Stage myStage) {

        // Give the stage a title.
        myStage.setTitle("Monitored Assignment1");

        // Create the GridPane.
        GridRoot gridRoot = new GridRoot();
        gridRoot.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET)); // Gaps at the outside borders


        int sceneWidth = gridRoot.getPaneWidth();
        int sceneHeight = gridRoot.getPaneHeight();


        // Create a scene.
        Scene myScene = new Scene(gridRoot, sceneWidth, sceneHeight);


        // Handle a mouse click event on the scene.
        myScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                switch (me.getButton()) {
                    case PRIMARY:
                        paint(me, gridRoot);
                        break;
                    case SECONDARY:
                        gridRoot.clear();
                        break;
                }
            }
        });

        // Handle a mouse dragged event on the scene.
        myScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                paint(me, gridRoot);
            }
        });


        // Set the scene on the stage.
        myStage.setScene(myScene);

        // Show the stage and its scene.
        myStage.show();
    }

    private void paint(MouseEvent me, GridRoot gridRoot) {
        double x = me.getX();
        double y = me.getY();
        double hgap = gridRoot.getHgap();
        double vgap = gridRoot.getVgap();
        int pixelWidth = gridRoot.getPixelWidth();
        int pixelHeight = gridRoot.getPixelHeight();

        int col = (int) ((x + hgap/2 - LEFT_INSET) / (pixelWidth + hgap));
        int row = (int) ((y + vgap/2 - TOP_INSET) / (pixelHeight + vgap));
        Pixel currentPixel = (Pixel) gridRoot.getPixelByIndexes(col, row);
        currentPixel.fill(true);
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
