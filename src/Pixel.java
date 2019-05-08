import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {

    Pixel(int width, int height, boolean fill) {
        setWidth(width);
        setHeight(height);
        fill(fill);
    }

    void fill(boolean fill) {
        if (fill) setFill(Color.BLACK);
        else setFill(Color.WHITE);

    }
}
