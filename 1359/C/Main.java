import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int h = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt();

            System.out.println(solve(h, c, t));
        }

        sc.close();
    }

    static int solve(int h, int c, int t) {
        if (2 * t <= h + c) {
            return 2;
        }

        int r = (h - t) / (2 * t - h - c);

        return (((long) r * (h + c) + h) * (2 * r + 3) + ((r + 1L) * (h + c) + h) * (2 * r + 1) <= 2L * t * (2 * r + 1)
                * (2 * r + 3)) ? (2 * r + 1) : (2 * r + 3);
    }
}