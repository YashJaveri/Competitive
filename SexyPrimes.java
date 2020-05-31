import java.io.*;
import java.util.*;

class SexyPrimes {

    static Boolean isPrime(int number) {
        double root = Math.sqrt((double) number);

        for (int i = 2; i <= root; i++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flag = 1;
        System.out.println("Enter the range: ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        System.out.println("How many terms to include in one set?");
        int size = scanner.nextInt();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                flag = 1;
                for (int j = 1; j < size; j++) {
                    if (!isPrime(i + 6 * j)) {
                        flag = 0;
                    }
                }
                if (flag == 1) {
                    System.out.print("The set of sexy primes: (");
                    for (int j = 0; j < size; j++)
                        if (j == size - 1)
                            System.out.print(i + 6 * j);
                        else
                            System.out.print(i + 6 * j + ", ");
                    System.out.print(")");
                    System.out.print("\n");
                }
            }
            flag = 0;
        }

        scanner.close();
    }
}