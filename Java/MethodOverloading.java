import java.util.Scanner;

class Area {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the shape:\n1-Circle\n2-Square\n3-Rectangle: ");
        int t = sc.nextInt();

        switch (t) {
        case 1:
            System.out.println("Enter the radius of the circle");
            double r = (double) sc.nextFloat();
            double ans1 = getArea(r);
            System.out.printf("The area is: %.2f\n", ans1);
            break;
        case 2:
            System.out.println("Enter the length of the square");
            int s = sc.nextInt();
            int ans2 = getArea(s);
            System.out.println("The area is: " + ans2);
            break;

        case 3:
            System.out.println("Enter the length, breadth of the rectangle");
            double l = (double) sc.nextFloat();
            double b = (double) sc.nextFloat();
            double ans3 = getArea(l, b);
            System.out.printf("The area is: %.2f\n", ans3);
            break;

        default:
            System.out.println("Invalid input!");
        }
        sc.close();
    }

    static double getArea(double _radius) {
        return Math.PI * _radius * _radius;
    }

    static int getArea(int side) {
        return side*side;
    }

    static double getArea(double length, double breadth) {
        return length*breadth;
    }
}