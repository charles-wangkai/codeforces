import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(solve(x1, y1, x2, y2));
        }

        sc.close();
    }

    static long solve(int x1, int y1, int x2, int y2) {
        int xDiff = x2 - x1;
        int yDiff = y2 - y1;

        if (xDiff == 0 || yDiff == 0) {
            return 1;
        }
        if (xDiff == 1) {
            return yDiff + 1;
        }
        if (yDiff == 1) {
            return xDiff + 1;
        }

        return xDiff + 1 + xDiff * (yDiff - 1L);
    }
}