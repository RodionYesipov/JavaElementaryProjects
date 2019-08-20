package painter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

import static painter.Main.BOARD_HEIGHT;
import static painter.Main.BOARD_WIDTH;

public class Board {
    private final GraphicsContext gc;
    @Expose
    private List<Shape> shapes = new ArrayList<>();


    public Board(GraphicsContext gc) {
        addShape(new Ball(gc, 100, 100, true));
        addShape(new Square(gc, 250, 100, false));
        addShape(new Triangle(gc, 200, 250, false));
        this.gc = gc;
    }

    public Board(List<Shape> shapes){
        this.gc = null;
        this.shapes = shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void deleteShape() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).isActive()) {
                shapes.remove(i);
                i--;
            }
        }
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void saveAll() throws Exception {
        /*for (Shape shape : shapes) {
            shape.saveShape();
        }*/
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String output = gson.toJson(this);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src//" + "output.txt")))) {
            System.out.println("Start saving....." + this.getClass().getName());
            writer.write(output);
            System.out.println("End saving....." + this.getClass().getName());
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
    }


    public void moveRight() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveRight();
            }
        }
    }

    public void moveLeft() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveLeft();
            }
        }
    }

    public void moveUp() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveUp();
            }
        }
    }

    public void moveDown() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.moveDown();
            }
        }
    }

    public void zoomIn() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.zoomIn();
            }
        }
    }

    public void zoomOut() {
        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.zoomOut();
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
        } else if (event.getCode() == KeyCode.DELETE) {
            deleteShape();
        } else if (event.getCode() == KeyCode.PAGE_UP) {
            zoomIn();
        } else if (event.getCode() == KeyCode.PAGE_DOWN) {
            zoomOut();
        } else if (event.getCode() == KeyCode.V && event.isControlDown()) {
            loadObjects();
        } else if (event.getCode() == KeyCode.C && event.isControlDown()) {
            cloneAll();
        } else if (event.getCode() == KeyCode.S && event.isControlDown()) {
            try {
                saveAll();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void loadObjects() {
        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        StringBuilder sb = new StringBuilder();
        String json;
        shapes.clear();
        Board restBoard;
        try (BufferedReader br = new BufferedReader(new FileReader("src//output.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = sb.toString();
        restBoard = gson.fromJson(json, Board.class);

        for (Shape shape:shapes) {
            shape.setGc();
        }

        this.shapes = restBoard.shapes;

    }
}
