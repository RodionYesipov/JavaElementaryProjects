import java.util.ArrayList;
import java.util.List;

/**
 3. Написать программу которая решает квадратное уравнене вида a*x*x + b*x + c = 0, где заданы a,b,c.
* */
public class ExtraHomeTask3 {
    private static List<Double> solveEquation(double a, double b, double c) {
        double discriminant;
        discriminant = b * b - 4 * a * c;
        List<Double> solutions = new ArrayList();
        if (discriminant == 0) {
            solutions.add(-b / (2 * a));
        } else if (discriminant > 0) {
            solutions.add(Math.round(-1*b + Math.sqrt(discriminant)) / (2 * a));
            solutions.add(Math.round(-1*b - Math.sqrt(discriminant)) / (2 * a));
        }
        return solutions;
    }

    ////////////////
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int c = 0;
        System.out.println(a + "*x*x + " + b + "*x + " + c + " = 0 \n Solutions: " + solveEquation(5, 6, 0));
    }
}