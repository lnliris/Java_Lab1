import java.util.Random;
import java.util.Scanner;

public class ApproximatePi {
    public static double approximatePi(int numSamples) {
        Random random = new Random();
        int insideCircle = 0;

        for (int i = 0; i < numSamples; i++) {
            double x = random.nextDouble() * 2 - 1; // Tọa độ x trong [-1, 1]
            double y = random.nextDouble() * 2 - 1; // Tọa độ y trong [-1, 1]

            if (x * x + y * y <= 1) { // Kiểm tra nếu điểm nằm trong đường tròn đơn vị
                insideCircle++;
            }
        }

        return (4.0 * insideCircle) / numSamples; // Xấp xỉ pi
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng mẫu: ");
        int numSamples = scanner.nextInt();
        scanner.close();

        System.out.println("Giá trị xấp xỉ của pi: " + approximatePi(numSamples));
    }
}
