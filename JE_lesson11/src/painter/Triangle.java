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

public class Triangle extends AbstractShape implements Shape {
    @Expose private boolean isActive = false;

    public Triangle(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw() {
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(new double[]{x, x + shapeSize, x + shapeSize / 2, x},
                new double[]{y, y, y + shapeSize, y}, 4
        );
        if (isActive) {
            gc.setFill(Color.rgb(152, 251, 152));
            gc.fillPolygon(new double[]{x, x + shapeSize, x + shapeSize / 2, x},
                    new double[]{y, y, y + shapeSize, y}, 4
            );
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
                new FileOutputStream("src//" + this.getClass().getName() + this.getClass().hashCode() +  ".txt")))) {
            System.out.println("Start saving....."+ this.getClass().getName() + this.getClass().hashCode());
            writer.write(output);
            System.out.println("End saving....." + this.getClass().getName() + this.getClass().hashCode());
        }
    }

    public Triangle(Triangle square) {
        this.x = square.x;
        this.y = square.y;
        this.gc = square.gc;
        this.shapeSize = square.shapeSize;
        this.isActive = !square.isActive;
    }

    public Triangle(GraphicsContext gc, int x, int y, boolean isActive) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.isActive = isActive;
    }

    public Triangle() {
    }
}
