package painter;

import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractShape {
    @Expose
    protected double x = 0;
    @Expose
    protected double y = 0;
    @Expose
    protected double xSpeed = 5;
    @Expose
    protected double ySpeed = 5;
    @Expose
    protected double deltaMove = 5;
    @Expose
    protected int shapeSize = 70;
    @Expose
    protected final double SCREEN_X = 800;
    @Expose
    protected final double SCREEN_Y = 600;
    @Expose
    protected GraphicsContext gc;


    public void moveRight() {
        x += deltaMove;
    }

    public void moveLeft() {
        x -= deltaMove;
    }

    public void moveUp() {
        y -= deltaMove;
    }

    public void moveDown() {
        y += deltaMove;
    }

    public void zoomIn() {
        shapeSize += deltaMove;
    }

    public void zoomOut() {
        shapeSize -= deltaMove;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getShapeSize() {
        return shapeSize;
    }

}

