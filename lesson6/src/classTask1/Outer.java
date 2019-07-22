package classTask1;

public class Outer {
    int x = 0;
    class Inner1{public int f(){return ++x;}}
    public void g(final int j){
        final int k = j;
        class Inner2{
            public int f(int r){
                return r*k + j;
            }
        }
        Inner2 i1 = new Inner2();
        int s = i1.f(10);
        System.out.println(s);
    }
}
