package painter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;

import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static painter.Main.BOARD_HEIGHT;
import static painter.Main.BOARD_WIDTH;

public class Board {
    private final GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
            /*if (shape.isActive()) {
                shape.draw();
                //shape.setShapeActive();
            }*/
        }
    }

    public void cloneAll() {
        List<Shape> cloneShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                if (shape.getClass().getName() == "painter.Ball") {
                    cloneShapes.add(new Ball((Ball) shape));
                    moveRight();
                } else if (shape.getClass().getName() == "painter.Square") {
                    cloneShapes.add(new Square((Square) shape));
                    moveRight();
                } else if (shape.getClass().getName() == "painter.Triangle") {
                    cloneShapes.add(new Triangle((Triangle) shape));
                    moveRight();
                }
            }
        }

        for (Shape shape : cloneShapes) {
            shapes.add(shape);
        }
        //drawAll();
    }


    public void moveRight() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveRight();
                shape.draw();
            }
        }
    }

    public void moveLeft() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveLeft();
                shape.draw();
            }
        }
    }

    public void moveUp() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveUp();
                shape.draw();
            }
        }
    }

    public void moveDown() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveDown();
                shape.draw();
            }
        }
    }

    public void zoomIn() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.zoomIn();
                shape.draw();
            } else {
                shape.draw();
            }
        }
    }

    public void zoomOut() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.zoomOut();
                shape.draw();
            }
        }
    }


    public void setShapeActive(double x, double y) {
        Shape tmp;
        double centerX;
        double centerY;
        double distFromClickToCenter;
        for (int i = 0; i < shapes.size(); i++) {
            tmp = shapes.get(i);
            centerX = tmp.getX() + tmp.getShapeSize() / 2;
            centerY = tmp.getY() + tmp.getShapeSize() / 2;
            distFromClickToCenter = Point2D.distance(x, y, centerX, centerY);
            if (distFromClickToCenter <= tmp.getShapeSize()) {
                tmp.setShapeActive();
            }
        }
    }

    public void keyPressed(KeyEvent event) {
        gc.clearRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        if (event.getCode() == KeyCode.RIGHT) {
            moveRight();
        } else if (event.getCode() == KeyCode.LEFT) {
            moveLeft();
        } else if (event.getCode() == KeyCode.UP) {
            moveUp();
        } else if (event.getCode() == KeyCode.DOWN) {
            moveDown();
        } else if (event.getCode() == KeyCode.DIGIT1) {
            addShape(new Ball(gc));
        } else if (event.getCode() == KeyCode.DIGIT2) {
            addShape(new Square(gc));
        } else if (event.getCode() == KeyCode.DIGIT3) {
            addShape(new Triangle(gc));
        } else if (event.getCode() == KeyCode.PAGE_UP) {
            zoomIn();
        } else if (event.getCode() == KeyCode.PAGE_DOWN) {
            zoomOut();
        } else if (event.getCode() == KeyCode.C && event.isControlDown()) {
            cloneAll();
        } else if (event.getCode() == KeyCode.S) {
            try {
                saveAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveAll() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Board out = this;
        String output = gson.toJson(out);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("output.txt")))) {
            writer.write(output);
        }
    }
}
