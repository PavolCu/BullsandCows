import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the components of the first vector
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        // Read the components of the second vector
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        scanner.close();

        // Calculate the dot product of the two vectors
        double dotProduct = x1 * x2 + y1 * y2;

        // Calculate the magnitudes of the two vectors
        double magnitude1 = Math.sqrt(x1 * x1 + y1 * y1);
        double magnitude2 = Math.sqrt(x2 * x2 + y2 * y2);

        // Calculate the angle between the two vectors in radians
        double angleInRadians = Math.acos(dotProduct / (magnitude1 * magnitude2));

        // Convert the angle from radians to degrees
        int angleInDegrees = (int) Math.toDegrees(angleInRadians);

        System.out.println(angleInDegrees);
    }
}