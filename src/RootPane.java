import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

class RootPane extends GridPane {
    private final int colCount;
    private final int rowCount;
    private final double hGap;
    private final double vGap;
    private final double pixelWidth;
    private final double pixelHeight;
    private final Color initColor;
    private final Color paintColor;

    RootPane(int colCount, int rowCount,
             double hGap, double vGap,
             double pixelWidth, double pixelHeight,
             Color initColor, Color paintColor) {
        // Initialize fields
        this.colCount = colCount;
        this.rowCount = rowCount;
        this.hGap = hGap;
        this.vGap = vGap;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.initColor = initColor;
        this.paintColor = paintColor;
        // Set vertical and horizontal gaps between controls.
        setVgap(vGap);
        setHgap(hGap);
        // Add pixels.
        pixelsInit(colCount, rowCount, pixelWidth, pixelHeight);
    }

    private void pixelsInit(int colCount, int rowCount, double pixelWidth, double pixelHeight) {
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                Pixel pixel = new Pixel(pixelWidth, pixelHeight, initColor);
                add(pixel, col, row);
            }
        }
    }

    void paint(MouseEvent mouseEvent) {
        int col = getIndex(mouseEvent.getX(), getHgap(), getPadding().getLeft(), pixelWidth);
        int row = getIndex(mouseEvent.getY(), getVgap(), getPadding().getTop(), pixelHeight);
        Pixel pixel = (Pixel) getChildNode(col, row);
        if (pixel != null) {
            pixel.setFill(paintColor);
        }
    }

    void clearAll() {
        for (int col = 0; col < colCount /*getColumnConstraints().size()*/; col++) {
            for (int row = 0; row < rowCount /*getRowConstraints().size()*/; row++) {
                Pixel pixel = (Pixel) getChildNode(col, row);
                pixel.setFill(initColor);
            }
        }
    }

    private int getIndex(double coordinate, double gap, double inset, double pixelSize) {
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

    private Node getChildNode(int col, int row) {
        for (Node node : getChildren()) {
            if (RootPane.getColumnIndex(node) == col && RootPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
