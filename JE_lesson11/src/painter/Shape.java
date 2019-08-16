package painter;

public interface Shape {

    void draw();

    void moveRight();

    void moveLeft();

    void moveUp();

    void moveDown();

    void zoomIn();

    void zoomOut();

    boolean isActive();

    double getX();

    double getY();

    double getShapeSize();

    void setShapeActive();

    void saveShape() throws Exception;
}