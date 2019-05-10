import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

class RootPane extends GridPane {

    static final int X_MAX = 16;
    static final int Y_MAX = 16;
    static final int H_GAP = 2;
    static final int V_GAP = 2;
    static final int PIXEL_WIDTH = 20;
    static final int PIXEL_HEIGHT = 20;
    static final int PANE_WIDTH = (PIXEL_WIDTH + H_GAP) * X_MAX;
    static final int PANE_HEIGHT = (PIXEL_HEIGHT + V_GAP) * Y_MAX;

    RootPane() {
        // Set vertical and horizontal gaps between controls.
        setVgap(V_GAP);
        setHgap(H_GAP);
        // Add columns, rows.
        pixelsInit(X_MAX, Y_MAX, PIXEL_WIDTH, PIXEL_HEIGHT);
    }

    private void pixelsInit(int colMax, int rowMax, int pixelWidth, int pixelHeight) {
        for (int col = 0; col < colMax; col++) {
            for (int row = 0; row < rowMax; row++) {
                Pixel pixel = new Pixel(pixelWidth, pixelHeight, Filler.WHITE);
                add(pixel, col, row);
            }
        }
    }

    private Node getChildNode(int col, int row) {
        for (Node node : getChildren()) {
            if (RootPane.getColumnIndex(node) == col && RootPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    void paint(MouseEvent me, RootPane rootPane) {
        int col = getIndex(me.getX(), rootPane.getHgap(), Main.LEFT_INSET, PIXEL_WIDTH);
        int row = getIndex(me.getY(), rootPane.getVgap(), Main.TOP_INSET, PIXEL_HEIGHT);
        Pixel currentPixel = (Pixel) rootPane.getChildNode(col, row);
        if (currentPixel != null) {
            currentPixel.fill(Filler.BLACK);
        }
    }

    private int getIndex(double coordinate, double gap, int inset, int pixelSize) {
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

    void clearAll() {
        for (int col = 0; col < X_MAX; col++) {
            for (int row = 0; row < Y_MAX; row++) {
                Pixel currentPixel = (Pixel) getChildNode(col, row);
                if (currentPixel != null) {
                    currentPixel.fill(Filler.WHITE);
                }
            }
        }
    }
}
