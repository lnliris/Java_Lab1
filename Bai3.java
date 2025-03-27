import java.util.*;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Số lượng trạm phát sóng
        List<int[]> stations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            stations.add(new int[] { x, y });
        }

        scanner.close();

        List<int[]> alertStations = determineAlertStations(stations);

        for (int[] station : alertStations) {
            System.out.println(station[0] + " " + station[1]);
        }
    }

    private static List<int[]> determineAlertStations(List<int[]> stations) {
        Set<int[]> convexHull = findConvexHull(stations);
        List<int[]> alertStations = new ArrayList<>(convexHull);

        alertStations.sort(Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));
        return alertStations;
    }

    private static Set<int[]> findConvexHull(List<int[]> points) {
        points.sort(Comparator.comparingInt((int[] p) -> p[0])
                .thenComparingInt(p -> p[1]));

        Stack<int[]> lower = new Stack<>(), upper = new Stack<>();

        for (int[] p : points) {
            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
                lower.pop();
            }
            lower.push(p);
        }

        Collections.reverse(points);

        for (int[] p : points) {
            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.pop();
            }
            upper.push(p);
        }

        Set<int[]> hull = new HashSet<>(lower);
        hull.addAll(upper);
        return hull;
    }

    private static int cross(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }
}
