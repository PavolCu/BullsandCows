import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        // Input coefficients a, b, and c
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Calculate discriminant (b^2 - 4ac)
        final double magicOne = 4;
        double discriminant = b * b - magicOne * a * c;

        // Calculate the two roots using the quadratic formula
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        // Output the roots in ascending order
        if (root1 < root2) {
            System.out.println(root1 + " " + root2);
        } else {
            System.out.println(root2 + " " + root1);
        }

        sc.close();
    }
}