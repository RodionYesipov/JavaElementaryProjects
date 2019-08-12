package painter;

public interface Shape {

    void move();
    void draw();

    void moveRight();
    void moveLeft();

    void moveUp();
    void moveDown();
    void zoomIn();
    void zoomOut();
}