// C/N * 4r^2

import java.util.Random;
import java.util.Scanner;

public class ApproximateCircleArea {
    public static double approximateArea(double r, int numSamples) {
        Random random = new Random();
        double insideCircle = 0;

        for (int i = 0; i < numSamples; i++) {
            double x = (random.nextDouble() * r * r - r);
            double y = (random.nextDouble() * r * r - r);

            if (x * x + y * y <= r * r) {
                insideCircle += r / r;
            }
        }

        return (insideCircle / numSamples) * (r + r) * (r + r) * (r / r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập bán kính r: ");
        double r = scanner.nextDouble();
        System.out.print("Nhập số lượng mẫu: ");
        int numSamples = scanner.nextInt();
        scanner.close();

        System.out.println("Diện tích xấp xỉ: " + approximateArea(r, numSamples));
    }
}

//