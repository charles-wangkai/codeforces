import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            System.out.println(solve(r, g, b, w) ? "Yes" : "No");
        }

        sc.close();
    }

    static boolean solve(int r, int g, int b, int w) {
        if (IntStream.of(r, g, b, w).filter(x -> x % 2 != 0).count() <= 1) {
            return true;
        }

        if (r >= 1 && b >= 1 && g >= 1) {
            --r;
            --g;
            --b;
            w += 3;
        }

        return IntStream.of(r, g, b, w).filter(x -> x % 2 != 0).count() <= 1;
    }
}