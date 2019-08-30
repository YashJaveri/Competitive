import java.util.Scanner;

class Binomial{

    public static void main(String[] args) {
        Scanner inp = new Scanner (System.in);
        System.out.println ("ax² + bx + c = 0");
        float a, b, c;
        
        System.out.print ("a >> ");
        a = inp.nextFloat ();
        System.out.print ("b >> ");
        b = inp.nextFloat ();
        System.out.print ("c >> ");
        c = inp.nextFloat ();
        inp.close();

        float d = b*b - 4*a*c;
        if (d < 0) {
            System.out.println ("Roots do not exist");
        } else if (d == 0) {
            System.out.println ("Roots are equal, root = " + (-b / (2*a)));
        } else {
            float r1 = (-b + d) / (2*a);
            float r2 = (-b - d) / (2*a);
            System.out.println ("root1 = " + r1 + ", root2 = " + r2);
        }
    }
}