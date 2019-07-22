package hometask6_loop;
/*
«1»: Вывести на экран фигуру (елочка)
 */
import java.util.Scanner;

public class hometask6_loop {
    public static void main(String[] args) {

        int last_line_num = 19; // кол-во * в нижней строке елки, число должно быть нечетным

        for(int i = (last_line_num+1)/2; i > 0; i--)
        {
            //spaces
            for(int j = 0; j < i-1; j++)
            {
                System.out.print(" ");
            }
            //*
            for(int k = 0; k <= last_line_num-i*2+1; k++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
