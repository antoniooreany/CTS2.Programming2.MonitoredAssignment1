import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

class RootPane extends GridPane {
    private final int colMax;
    private final int rowMax;
    private final double hGap;
    private final double vGap;
    private final double pixelWidth;
    private final double pixelHeight;
    private final Color initColor;
    private final Color paintColor;

    RootPane(int colMax, int rowMax, double hGap, double vGap, double pixelWidth, double pixelHeight,
             Color initColor, Color paintColor) {
        // Initialize variables
        this.colMax = colMax;
        this.rowMax = rowMax;
        this.hGap = hGap;
        this.vGap = vGap;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.initColor = initColor;
        this.paintColor = paintColor;
        // Set vertical and horizontal gaps between controls.
        setVgap(vGap);
        setHgap(hGap);
        // Add columns, rows.
        pixelsInit(colMax, rowMax, pixelWidth, pixelHeight/*, initFiller*/);
    }

    private void pixelsInit(int colMax, int rowMax, double pixelWidth, double pixelHeight) {
        for (int col = 0; col < colMax; col++) {
            for (int row = 0; row < rowMax; row++) {
                Pixel pixel = new Pixel(pixelWidth, pixelHeight, initColor);
                add(pixel, col, row);
            }
        }
    }

    void paint(MouseEvent me) {
        int col = getIndex(me.getX(), getHgap(), getPadding().getLeft(), pixelWidth);
        int row = getIndex(me.getY(), getVgap(), getPadding().getTop(), pixelHeight);
        Pixel pixel = (Pixel) getChildNode(col, row);
        if (pixel != null) {
            pixel.setFill(paintColor);
        }
    }

    void clearAll() {
        for (int col = 0; col < colMax; /*getColumnConstraints().size()*/ col++) {
            for (int row = 0; row < rowMax; /*getRowConstraints().size()*/ row++) {
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
