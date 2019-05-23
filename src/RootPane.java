import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

class RootPane extends GridPane {
    // TODO Do we need all of these fields?
    // TODO If not, than How to avoid creating these fields?
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
        fillRoot();
    }

    // Root filler method
    private void fillRoot() {
        // All the pixels of the rootPane creation in the loop to fill them by "initColor" = initialize them
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                // A new pixel addition
                addNewPixel(row, col, initColor);
            }
        }
    }

    // Paint method
    private void paint(MouseEvent mouseEvent) {
        // Column, row of pixel to paint initialization
        int col = getPixelPositionIndex(mouseEvent.getX(), hGap, getPadding().getLeft(), pixelWidth);
        int row = getPixelPositionIndex(mouseEvent.getY(), vGap, getPadding().getTop(), pixelHeight);
        // Create the painted pixel, put it in the appropriate position (if it exists) in the rootPane
        if (col >= 0 && col < colCount
                && row >= 0 && row < rowCount) {
            // A new pixel addition
            addNewPixel(row, col, paintColor);
        }
    }

    // A new pixel addition method
    private void addNewPixel(int row, int col, Color color) {
        Pixel pixel = new Pixel(pixelWidth, pixelHeight, color);
        add(pixel, col, row);
    }

    // Position index getting method
    private int getPixelPositionIndex(double coordinate, double gap, double inset, double pixelSize) {
        // Position index calculation
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

    // MouseEventHandler: events initialization for the left and right mouse buttons
    EventHandler<MouseEvent> getMouseEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // in case of PRIMARY BUTTON - paint
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    paint(mouseEvent);
                    // in case of SECONDARY BUTTON - clear
                } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    fillRoot();
                }
            }
        };
    }
}
