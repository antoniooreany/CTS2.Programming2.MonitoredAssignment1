import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {

    Pixel(int width, int height, Filler filler) {
        setWidth(width);
        setHeight(height);
        fill(filler);
    }

    void fill(Filler filler) {
        if (filler == Filler.BLACK) {
            setFill(Color.BLACK);
        } else if (filler == Filler.WHITE) {
            setFill(Color.WHITE);
        }

    }
}
