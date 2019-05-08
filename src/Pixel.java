import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {

    Pixel(int width, int height, Filler filler) {
        setWidth(width);
        setHeight(height);
        fill(filler);
    }

    void fill(Filler filler) {
        switch (filler) {
            case BLACK:
                setFill(Color.BLACK);
                break;
            case WHITE:
                setFill(Color.WHITE);
        }

    }
}
