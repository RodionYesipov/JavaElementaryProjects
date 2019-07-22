package innerOuterClasses;

import java.awt.*;

public class ShapeFactory {
    private class Triangle implements Shape{
        float a,b,c;
        Triangle(float a, float b, float c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public void draw(){
            System.out.println(a + " " + b + " " + c);
        }
    }

    private class Circle implements Shape{
        float r;
        Circle(float r){
            this.r = r;
        }
        public void draw(){
            System.out.println(r);
        }
    }

    public Shape createTriangle(float a, float b, float c){
        return new Triangle(a,b,c);
    }
    public Shape createCircle(float r){
        return new Circle(r);
    }

    public interface Shape{
        void draw();
    }
}
