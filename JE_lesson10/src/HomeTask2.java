import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//нарисовть шар который сам двигается и отбивается от краев экрана
public class HomeTask2 extends Application {

    private static final int BOARD_WIDTH = 500;

    private static final int BOARD_HEIGHT = 500;

    private double x = 250;
    private double y = 250;
    double deltaX = 1;
    double deltaY = 0.5;
    boolean rightDirection = true;
    boolean downDirection = true;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SimpleGame");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        move(gc);
    }


    private void move(GraphicsContext gc) {
        new Thread(new Runnable() {

            @Override
            public void run() {

                double ovalH = 40;
                double ovalW = 40;

                while (true) {
                    gc.clearRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
                    gc.setFill(Color.RED);
                    gc.fillOval(x, y, ovalW, ovalH);

                    try {
                        Thread.sleep(5);

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }

                    if (rightDirection) {
                        if (downDirection) {
                            x += deltaX;
                            y += deltaY;
                        } else {
                            x += deltaX;
                            y -= deltaY;
                        }
                    } else {
                        if (downDirection) {
                            x -= deltaX;
                            y += deltaY;
                        } else {
                            x -= deltaX;
                            y -= deltaY;
                        }
                    }

                    ////////////////
                    if (x == BOARD_WIDTH - ovalW || x == 0) {
                        rightDirection = !rightDirection;
                    }
                    if (y == BOARD_HEIGHT - ovalH || y == 0) {
                        downDirection = !downDirection;
                    }
                    ///////////////
                }
            }
        }).start();
    }
}