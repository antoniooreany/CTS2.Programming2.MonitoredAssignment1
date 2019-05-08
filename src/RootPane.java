import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

class RootPane extends GridPane {

    private static final int X_MAX = 16;
    private static final int Y_MAX = 16;
    private static final int H_GAP = 2;
    private static final int V_GAP = 2;
    private static final int PIXEL_WIDTH = 20;
    private static final int PIXEL_HEIGHT = 20;
    private static final int PANE_WIDTH = (PIXEL_WIDTH + H_GAP) * X_MAX;
    private static final int PANE_HEIGHT = (PIXEL_HEIGHT + V_GAP) * Y_MAX;

    private int getPixelWidth() {
        return PIXEL_WIDTH;
    }

    private int getPixelHeight() {
        return PIXEL_HEIGHT;
    }

    int getPaneWidth() {
        return PANE_WIDTH;
    }

    int getPaneHeight() {
        return PANE_HEIGHT;
    }

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

    private int getColumnIndex(MouseEvent me, RootPane rootPane) {
        double x = me.getX();
        double hGap = rootPane.getHgap();
        int pixelWidth = rootPane.getPixelWidth();
        int leftInset = Main.getLeftInset();
        int col = (int) ((x + hGap / 2 - leftInset) / (pixelWidth + hGap));
        return col;
    }

    private int getRowIndex(MouseEvent me, RootPane rootPane) {
        double y = me.getY();
        double vGap = rootPane.getVgap();
        int pixelHeight = rootPane.getPixelHeight();
        int topInset = Main.getTopInset();
        int row = (int) ((y + vGap / 2 - topInset) / (pixelHeight + vGap));
        return row;
    }

    void paint(MouseEvent me, RootPane rootPane) {
        int col = getColumnIndex(me, rootPane);
        int row = getRowIndex(me, rootPane);
        Pixel currentPixel = (Pixel) rootPane.getChildNode(col, row);
        if (currentPixel != null) {
            currentPixel.fill(Filler.BLACK);
        }
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
