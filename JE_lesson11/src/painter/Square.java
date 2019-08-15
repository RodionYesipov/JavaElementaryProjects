package painter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends AbstractShape implements Shape {
    private final GraphicsContext gc;
    private boolean isActive = false;

    public Square(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw() {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, shapeSize, shapeSize);
        if (isActive) {
            gc.setFill(Color.RED);
            gc.fillRect(x, y, shapeSize, shapeSize);
        }
    }

    public void setShapeActive() {
        isActive = !isActive;
    }

   /* public void addShape(Shape square) {
        draw();
    }*/

    @Override
    public boolean isActive() {
        return isActive;
    }

    public Square(Square square) {
        this.x = square.x;
        this.y = square.y;
        this.gc = square.gc;
        this.shapeSize = square.shapeSize;
        this.isActive = !square.isActive;
    }
}
