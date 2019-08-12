package painter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Ball implements Shape {

    public static int shapeSize = 50;
    private final GraphicsContext gc;
    private final double SCREEN_X;
    private final double SCREEN_Y;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;

    public Ball(GraphicsContext gc) {
        this.gc = gc;
        SCREEN_X = gc.getCanvas().getWidth();
        SCREEN_Y = gc.getCanvas().getHeight();

        Random random = new Random();

        xSpeed = random.nextInt(10) - 5;
        ySpeed = random.nextInt(10) - 5;

        x = random.nextInt(400) + 20;
        y = random.nextInt(400) + 20;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x + shapeSize > SCREEN_X) {
            xSpeed = - (Math.abs(xSpeed));
        }
        if (y + shapeSize > SCREEN_Y) {
            ySpeed = - (Math.abs(ySpeed));
        }
        if (x < 0) {
            xSpeed = Math.abs(xSpeed);
        }
        if (y < 0) {
            ySpeed = Math.abs(ySpeed);
        }
    }

    public void draw() {
        //gc.setFill(Color.RED);
        //gc.fillOval(x, y, shapeSize, shapeSize);

        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, shapeSize, shapeSize);
    }

    public void moveRight() {
        x += 5;
    }

    public void moveLeft() {
        x -= 5;
    }

    @Override
    public void moveUp() {
        y -= 5;
    }

    public void moveDown() {
        y += 5;
    }

    @Override
    public void zoomIn() {
       shapeSize += 5;
    }

    @Override
    public void zoomOut() {
        shapeSize -= 5;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setShapeActive(){

    }
}
