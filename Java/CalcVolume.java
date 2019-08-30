import java.util.Scanner;

public class CalcVolume {

    public static void main(String[] args) {
        double ans = getInput();

        System.out.printf("Volume is: %.02f\n", ans);
    }

    static double getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the structure type:\n1-Cube\n2-Cuboid\n3-Cylinder\n4-Sphere: ");
        int t = sc.nextInt();

        switch (t) {
        case 1:
            System.out.println("Enter the length of the cube");
            double s = (double)sc.nextFloat();
            Volume cubeVol = new Volume(s, s, s);
            return cubeVol.getCubeVolume();

        case 2:
            System.out.println("Enter the length, breadth, height of the cuboid");
            double l = sc.nextFloat();
            double b = (double) sc.nextFloat();
            double h = (double) sc.nextFloat();
            Volume cuboidVol = new Volume(l, b, h);
            return cuboidVol.getCuboidVolume();

        case 3:
            System.out.println("Enter the redius, height of the cylinder");
            double r = (double) sc.nextFloat();
            double height = sc.nextDouble();
            Volume cylVol = new Volume(r, height);
            return cylVol.getCylinderVolume();

        case 4:
            System.out.println("Enter the redius of the sphere");
            double rad = (double) sc.nextFloat();
            Volume sphereVol = new Volume(rad);
            return sphereVol.getSphereVolume();

        default:
            System.out.println("Invalid input!");
            return 0.0;
        }
    }
}