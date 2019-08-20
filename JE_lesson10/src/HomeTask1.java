import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;

//нарисовать дом и Андрея рядом

public class HomeTask1 extends Application {

    private static final int BOARD_WIDTH = 500;

    private static final int BOARD_HEIGHT = 500;

    private double x = 0;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("House");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        FlowPane group = new FlowPane();
        group.getChildren().add(canvas);
        ////////////////////
        Class<?> clazz = this.getClass();

        InputStream input = clazz.getResourceAsStream("/foto-Kadatskiy.jpg");
        Image image = new Image(input, 140, 150, false, true);
        ImageView imageView = new ImageView(image);

        group.getChildren().add(imageView);

        group.getChildren().add(new Button("Hello"));

        group.setAlignment(Pos.CENTER);

        ///////////////////
        Scene scene = new Scene(group);
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawHouse(gc);
    }

    private void drawHouse(GraphicsContext gc) {

        gc.setFill(Color.BLACK);
        gc.fillOval(0,0,20,20);
        //house body
        double housebodyX = BOARD_WIDTH / 5.0;
        double housebodyY = BOARD_HEIGHT - 200;
        double housebodyW = 300;
        double housebodyH = 150;

        gc.setFill(Color.BEIGE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.fillRect(housebodyX, housebodyY, housebodyW, housebodyH);
        gc.strokeRect(housebodyX, housebodyY, housebodyW, housebodyH);

        //window
        double windowX = housebodyX + 20;
        double windowY = housebodyY + 20;
        double windowW = 30;
        double windowH = 20;
        double windowLineWidth = 5;

        gc.setFill(Color.DEEPSKYBLUE);
        gc.setStroke(Color.SADDLEBROWN);
        gc.setLineWidth(windowLineWidth);
        gc.fillRect(windowX, windowY, windowW, windowH);
        gc.strokeRect(windowX, windowY, windowW, windowH);

        gc.fillRect(windowX + windowW + windowLineWidth, windowY, windowW, windowH);
        gc.strokeRect(windowX + windowW + windowLineWidth, windowY, windowW, windowH);

        gc.fillRect(windowX + windowW + windowLineWidth, windowY, windowW, windowH);
        gc.strokeRect(windowX + windowW + windowLineWidth, windowY, windowW, windowH);

        gc.fillRect(windowX + windowW + windowLineWidth, windowY + windowH + windowLineWidth, windowW, windowH);
        gc.strokeRect(windowX + windowW + windowLineWidth, windowY + windowH + windowLineWidth, windowW, windowH);

        gc.fillRect(windowX, windowY + windowH + windowLineWidth, windowW, windowH);
        gc.strokeRect(windowX, windowY + windowH + windowLineWidth, windowW, windowH);

        //door
        double doorX = housebodyX + housebodyW - 80;
        double doorY = housebodyY + housebodyH - 80;
        double doorW = 50;
        double doorH = 80;
        double doorLineWidth = 5;

        gc.setFill(Color.ROSYBROWN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillRect(doorX, doorY, doorW, doorH);
        gc.strokeRect(doorX, doorY, doorW, doorH);

        gc.setFill(Color.BLACK);
        gc.fillOval(doorX + doorW - 10, doorY + doorH / 2, 5, 5);

        //roof + chimney
        double roofHeight = 100;
        double roofWidth = 40;
        double roofX1 = housebodyX - 20;
        double roofY1 = housebodyY;
        double roofX2 = housebodyX + housebodyW / 2 - roofWidth;
        double roofY2 = housebodyY - roofHeight;
        double roofX3 = housebodyX + housebodyW / 2 + roofWidth;
        double roofY3 = housebodyY - roofHeight;
        double roofX4 = housebodyX + housebodyW + 20;
        double roofY4 = housebodyY;

        double chimneyX = roofX3 + 30;
        double chimneyY = roofY3 - 40;
        double chimneyW = 20;
        double chimneyH = 100;

        //chimney
        gc.setFill(Color.BLACK);
        gc.fillRect(chimneyX, chimneyY, chimneyW, chimneyH);
        //roof
        gc.setFill(Color.rgb(160, 82, 45));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokePolygon(new double[]{roofX1, roofX2, roofX3, roofX4, roofX1},
                new double[]{roofY1, roofY2, roofY3, roofY4, roofY1}, 5);
        gc.fillPolygon(new double[]{roofX1, roofX2, roofX3, roofX4, roofX1},
                new double[]{roofY1, roofY2, roofY3, roofY4, roofY1}, 5);


    }
}