import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {
    Pixel(double width, double height, Color color) {
        setWidth(width);
        setHeight(height);
        setFill(color);
    }
}
