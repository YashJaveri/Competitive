import java.util.Scanner;
import java.lang.Math;

public class SineCalculator {

    public static void main(String[] args) {
        double inpInDegrees;
        double rad, term=1, sine,temp=1.0;

        System.out.println("Enter the angle:");
        Scanner sc = new Scanner(System.in);
        inpInDegrees = sc.nextDouble();
        sc.close();

        rad = Math.toRadians(inpInDegrees);
        sine = rad;
        for (int i = 3; term > 0.00000000001; i+=2) {
            term = Math.pow(rad, i) / fact(i);
            sine -= temp*term;
            temp *= -1;
        }
        System.out.println("sinx = " + String.format("%.3f",sine));
    }

    static int fact(int x) {
        if (x <= 0)
            return 1;
        else
            return (x*fact(x - 1));
    }
}