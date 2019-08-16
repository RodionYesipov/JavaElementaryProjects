package painter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {

    protected static final int BOARD_WIDTH = 800;
    protected static final int BOARD_HEIGHT = 600;

    private boolean closed = false;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SimpleGame");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        FlowPane group = new FlowPane();
        group.getChildren().add(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                board.keyPressed(event);
            }
        });

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                board.setShapeActive(event.getX(), event.getY());
            }
        });
        board = new Board(gc);
        startMoving(gc);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        closed = true;
    }

    private void startMoving(GraphicsContext gc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!closed) {
                    gc.clearRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
                    board.drawAll();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
