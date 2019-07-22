package innerOuterClasses;

public class Outer {
    int y;
    Outer(int x){
        y = x;
    }
    class Inner1{

    }

    void g(String S){
        class Inner2{

        }
    }
}
