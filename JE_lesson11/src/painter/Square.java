package painter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Square extends AbstractShape implements Shape {
    @Expose private boolean isActive = false;

    public Square(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw() {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, shapeSize, shapeSize);
        if (isActive) {
            gc.setFill(Color.rgb(152, 251, 152));
            gc.fillRect(x, y, shapeSize, shapeSize);
        }
    }

    public void setShapeActive() {
        isActive = !isActive;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public void saveShape() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String output = gson.toJson(this);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src//" + this.getClass().getName() + this.hashCode() +  ".txt")))) {
            System.out.println("Start saving....."+ this.getClass().getName() + this.hashCode());
            writer.write(output);
            System.out.println("End saving....." + this.getClass().getName() + this.hashCode());
        }
    }

    public void setGc() {
        this.gc = super.gc;
    }

    public Square(Square square) {
        this.x = square.x;
        this.y = square.y;
        this.gc = square.gc;
        this.shapeSize = square.shapeSize;
        this.isActive = !square.isActive;
    }

    public Square(GraphicsContext gc, int x, int y, boolean isActive) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.isActive = isActive;
    }

    public Square() {
    }
}
