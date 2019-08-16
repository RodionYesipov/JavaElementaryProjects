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
    @Expose
    private final GraphicsContext gc;
    @Expose
    private List<Shape> shapes = new ArrayList<>();


    public Board(GraphicsContext gc) {
        addShape(new Ball(gc, 100, 100, true));
        addShape(new Square(gc, 250, 100, false));
        addShape(new Triangle(gc, 200, 250, false));
        this.gc = gc;
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
        for (Shape shape : shapes) {
            shape.saveShape();
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
        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        StringBuilder sb = new StringBuilder();
        Map<String, String> fileStringMap = loadFromFile(sb);
        String json;
        shapes.clear();
        Ball restBall;
        Square restSquare;
        Triangle restTriangle;
        int startIndex;
        int endIndex;
        String fileName;

        for (Map.Entry<String, String> entry : fileStringMap.entrySet()) {

            fileName = entry.getKey();
            if (fileName.indexOf(Ball.class.getName()) > 0) {

                startIndex = fileName.indexOf(Ball.class.getName());
                endIndex = fileName.indexOf(Ball.class.getName()) + Ball.class.getName().length();
                fileName = fileName.substring(startIndex, endIndex);

            } else if (fileName.indexOf(Square.class.getName()) > 0) {

                startIndex = fileName.indexOf(Square.class.getName());
                endIndex = fileName.indexOf(Square.class.getName()) + Square.class.getName().length();
                fileName = fileName.substring(startIndex, endIndex);

            } else if (fileName.indexOf(Triangle.class.getName()) > 0) {

                startIndex = fileName.indexOf(Triangle.class.getName());
                endIndex = fileName.indexOf(Triangle.class.getName()) + Triangle.class.getName().length();
                fileName = fileName.substring(startIndex, endIndex);

            }

            if (fileName.equals(Ball.class.getName())) {

                json = entry.getValue();
                restBall = gson.fromJson(json, Ball.class);
                restBall.gc = this.gc;
                shapes.add(restBall);

            } else if (fileName.equals(Square.class.getName())) {

                json = entry.getValue();
                restSquare = gson.fromJson(json, Square.class);
                restSquare.gc = this.gc;
                shapes.add(restSquare);

            } else if (fileName.equals(Triangle.class.getName())) {

                json = entry.getValue();
                restTriangle = gson.fromJson(json, Triangle.class);
                restTriangle.gc = this.gc;
                shapes.add(restTriangle);

            }
        }
    }

    private Map<String, String> loadFromFile(StringBuilder sb) {
        File dir = new File("src//");
        File[] listFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
            }
        });
        System.out.println(Arrays.asList(listFiles));
        Map<String, String> fileStringMap = new HashMap<>();

        for (File file : listFiles) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    sb.append(currentLine);
                }
                br.close();
                fileStringMap.put(file.toString(), sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileStringMap;
    }

}
