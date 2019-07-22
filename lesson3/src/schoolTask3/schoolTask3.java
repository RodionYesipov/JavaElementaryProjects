package schoolTask3;
//«2»: Вывести сумму всех четных чисел от 100 до 450

public class schoolTask3 {
    public static void main(String[] args) {
        int a,b,summa;

        a = 100;
        b = 450;
        summa = 0;

        for(int i = a; i <= b; i++)
        {
            if(i%2 == 0)
            {
                //System.out.println(i);
                summa = summa + i;
            }
        }
        System.out.println("Summa = " + summa);
    }
}
