package innerOuterClasses;

public class Outside {
    public static void main(String args[]){
        ShapeFactory f = new ShapeFactory();

        ShapeFactory.Shape s1 = f.createCircle(10);

        ShapeFactory.Shape s2 = f.createTriangle(2,3,4);

        s1.draw();
        s2.draw();
    }
}
