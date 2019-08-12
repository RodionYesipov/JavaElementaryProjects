package painter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;

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
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                gc.clearRect(0,0,BOARD_WIDTH,BOARD_HEIGHT);
                if (event.getCode() == KeyCode.RIGHT) {
                    board.moveRight();
                } else if (event.getCode() == KeyCode.LEFT){
                    board.moveLeft();
                } else if(event.getCode() == KeyCode.UP){
                    board.moveUp();
                } else if(event.getCode() == KeyCode.DOWN){
                    board.moveDown();
                }  else if (event.getCode() == KeyCode.DIGIT1){
                    board.addShape(new Ball(gc));
                } else if (event.getCode() == KeyCode.PAGE_UP){
                    board.zoomIn();
                } else if (event.getCode() == KeyCode.PAGE_DOWN){
                    board.zoomOut();
                }
            }
        });

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                event.getX()
            }
        });
        board = new Board(gc);
//        scene.setOnKeyPressed(event -> board.keyPressed(event.getCode()));
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
                    board.draw();
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
