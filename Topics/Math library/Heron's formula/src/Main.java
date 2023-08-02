import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read input (side lengths)
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        // Calculate the semi-perimeter (half-perimeter)
        double p = (a + b + c) / 2.0;

        // Calculate the area using Heron's formula
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println(area);

        scanner.close();
    }
}