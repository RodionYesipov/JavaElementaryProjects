package hometask11_loop;
/*«1»: Ввести a и b и вывести квадраты и кубы чисел от a до b.

Пример:

Введите границы интервала:

4 6

4 16 64

5 25 125

6 36 216
*/
public class hometask11_loop {
    public static void main(String[] args) {
        int kvadrat,kub;

        for(int i = 8; i >= 1; i--)
        {
            kvadrat = i * i;
            kub = kvadrat * i;

            System.out.println(i + " kvadrat=" + kvadrat + " kub=" + kub + "\n");
        }
    }
}
