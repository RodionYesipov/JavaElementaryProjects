package painter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Ball extends AbstractShape implements Shape {

    private final GraphicsContext gc;
    private boolean isActive = false;

    public Ball(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw() {
         gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, shapeSize, shapeSize);
        if (isActive) {
            gc.setFill(Color.RED);
            gc.fillOval(x, y, shapeSize, shapeSize);
        }
    }

    public void setShapeActive() {
        isActive = !isActive;
        //draw();
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

   /* public void addShape(Shape ball) {
        draw();
    }*/

    public Ball(Ball ball) {
        this.x = ball.x;
        this.y = ball.y;
        this.gc = ball.gc;
        this.shapeSize = ball.shapeSize;
        this.isActive = !ball.isActive;
    }

}
