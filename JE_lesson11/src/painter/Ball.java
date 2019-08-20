package painter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.*;

public class Ball extends AbstractShape implements Shape {

    @Expose
    private boolean isActive = false;

    public Ball(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw() {
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, shapeSize, shapeSize);
        if (isActive) {
            gc.setFill(Color.rgb(152, 251, 152));
            gc.fillOval(x, y, shapeSize, shapeSize);
        }
    }

    public void setShapeActive() {
        isActive = !isActive;
    }

    @Override
    public void setGc() {
        this.gc = super.gc;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public Ball(Ball ball) {
        this.x = ball.x;
        this.y = ball.y;
        this.gc = ball.gc;
        this.shapeSize = ball.shapeSize;
        this.isActive = !ball.isActive;
    }

    public void saveShape() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String output = gson.toJson(this);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src//" + this.getClass().getName() + this.hashCode() + ".txt")))) {
            System.out.println("Start saving....." + this.getClass().getName() + this.hashCode());
            writer.write(output);
            System.out.println("End saving....." + this.getClass().getName() + this.hashCode());
        }
    }

    public Ball(GraphicsContext gc, int x, int y, boolean isActive) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.isActive = isActive;
    }

    public Ball() {
    }
}
