package classTask1;

import javax.sound.midi.Soundbank;

public class Outside {
    public static void g1(){
        Outer t1 = new Outer();
        Outer.Inner1 i2 = t1.new Inner1();
        System.out.println(i2.f());

        t1.g(5);
    }

    public static void main(String args[]){
        g1();
    }
}
