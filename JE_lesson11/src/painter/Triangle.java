package painter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends AbstractShape implements Shape {
    private final GraphicsContext gc;
    private boolean isActive = false;

    public Triangle(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw() {
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(new double[]{x, x + shapeSize, x + shapeSize / 2, x},
                new double[]{y, y, y + shapeSize, y}, 4
        );
        if (isActive) {
            gc.setFill(Color.RED);
            gc.fillPolygon(new double[]{x, x + shapeSize, x + shapeSize / 2, x},
                    new double[]{y, y, y + shapeSize, y}, 4
            );
        }
    }

    public void setShapeActive() {
        isActive = !isActive;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public Triangle(Triangle square) {
        this.x = square.x;
        this.y = square.y;
        this.gc = square.gc;
        this.shapeSize = square.shapeSize;
        this.isActive = !square.isActive;
    }
}
