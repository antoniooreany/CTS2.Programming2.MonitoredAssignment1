import javafx.scene.Node;
import javafx.scene.layout.GridPane;

class GridRoot extends GridPane {

    private static final int X_MAX = 16;
    private static final int Y_MAX = 16;
    private static final int H_GAP = 2;
    private static final int V_GAP = 2;
    private static final int PIXEL_WIDTH = 20;
    private static final int PIXEL_HEIGHT = 20;
    private static final int PANE_WIDTH = (PIXEL_WIDTH + H_GAP) * X_MAX;
    private static final int PANE_HEIGHT = (PIXEL_HEIGHT + V_GAP) * Y_MAX;

    int getPixelWidth() {
        return PIXEL_WIDTH;
    }

    int getPixelHeight() {
        return PIXEL_HEIGHT;
    }

    int getPaneWidth() {
        return PANE_WIDTH;
    }

    int getPaneHeight() {
        return PANE_HEIGHT;
    }

    GridRoot() {
        // Set vertical and horizontal gaps between controls.
        setVgap(V_GAP);
        setHgap(H_GAP);

        // Add columns, rows.
        pixelsInit(X_MAX, Y_MAX, PIXEL_WIDTH, PIXEL_HEIGHT);
    }

    private void pixelsInit(int xMax, int yMax, int pixelWidth, int pixelHeight) {
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                Pixel pixel = new Pixel(pixelWidth, pixelHeight, Filler.WHITE);
                add(pixel, x, y);
            }
        }
    }

    Node getPixelByIndexes(int x, int y) {
        for (Node pixel : getChildren()) {
            if (GridPane.getColumnIndex(pixel) == x && GridPane.getRowIndex(pixel) == y) {
                return pixel;
            }
        }
        return null;
    }

    void clearAll() {
        for (int x = 0; x < X_MAX; x++) {
            for (int y = 0; y < Y_MAX; y++) {
                Pixel currentPixel = (Pixel) getPixelByIndexes(x, y);
                currentPixel.fill(Filler.WHITE);
            }
        }
    }
}
