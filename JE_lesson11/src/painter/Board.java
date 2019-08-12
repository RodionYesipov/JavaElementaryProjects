package painter;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        //shapes.add(new Ball(gc));
    }

    public void addShape(Ball ball){

        shapes.add(new Ball(gc));
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void move() {
        for (Shape shape : shapes) {
            shape.move();
        }
    }

    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
            shape.draw();
        }
    }

    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
        }
    }

    public void moveUp() {
        for (Shape shape : shapes) {
            shape.moveUp();
        }
    }

    public void moveDown() {
        for (Shape shape : shapes) {
            shape.moveDown();
        }
    }

    public void zoomIn() {
        for (Shape shape : shapes) {
            shape.zoomIn();
        }
    }

    public void zoomOut() {
        for (Shape shape : shapes) {
            shape.zoomOut();
        }
    }

    public void setShapeActive(double x, double y){
        shapes.se
    }

}
