import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        // Initialize pixels.
        pixelsInit(colCount, rowCount, pixelWidth, pixelHeight);
    }

    // Pixels initialization method
    private void pixelsInit(int colCount, int rowCount, double pixelWidth, double pixelHeight) {
        // All the pixels of the rootPane creation in the loop to fill them by "initColor" = initialize them
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                // A new pixel creation
                Pixel pixel = new Pixel(pixelWidth, pixelHeight, initColor);
                // Adding the new pixel into rootPane
                add(pixel, col, row);
            }
        }
    }

    // Paint method
    void paint(MouseEvent mouseEvent) {
        // Column, row of pixel to paint initialization
        int col = getPixelPositionIndex(mouseEvent.getX(), getHgap(), getPadding().getLeft(), pixelWidth);
        int row = getPixelPositionIndex(mouseEvent.getY(), getVgap(), getPadding().getTop(), pixelHeight);
        // Finding the pixel to paint by its column and row
        Pixel pixel = (Pixel) getChildNode(col, row);
        // Painting the pixel (if it exists) by the "paintColor" = paint it
        if (pixel != null) {
            pixel.setFill(paintColor);
        }
    }

    // Clear method
    void clearAll() {
        // All the pixels of the rootPane loop to fill them by "initColor" = clear them
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                // Finding the pixel to paint by its column and row
                Pixel pixel = (Pixel) getChildNode(col, row);
                // Painting the pixel (if it exists) by the "initColor" = clear it
                pixel.setFill(initColor);
            }
        }
    }

    // Position index getting method
    private int getPixelPositionIndex(double coordinate, double gap, double inset, double pixelSize) {
        // Position index calculation
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

//     Pixel getting method
    // TODO Remove redundant getChildNode(), not paint the pixels, but add new already painted pixels with if() statement,
    // TODO
//    if (x < PWIDTH && y < PHEIGHT) {
//        Rectangle rectangle = new Rectangle(RWIDTH, RHEIGHT, Color.BLACK);
//        grid.add(rectangle, x, y);
//    }
    private Node getChildNode(int col, int row) {
//         Going through all of the pixels in the loop and finding with a particular column, row
        for (Node node : getChildren()) {
            if (RootPane.getColumnIndex(node) == col && RootPane.getRowIndex(node) == row) {
                return node;
            }
        }
//         If the pixel with a particular column, row is not found, return null
        return null;
    }
}
