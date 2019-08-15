package painter;

import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractShape {
    protected double x = 0;
    protected double y = 0;
    protected double xSpeed = 5;
    protected double ySpeed = 5;
    protected double deltaMove = 5;
    protected int shapeSize = 50;
    protected final double SCREEN_X = 800;
    protected final double SCREEN_Y = 600;
    boolean isActive = false;
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

