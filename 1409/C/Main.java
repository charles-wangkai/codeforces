import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solve(n, x, y));
        }

        sc.close();
    }

    static String solve(int n, int x, int y) {
        for (int d = 1;; ++d) {
            if ((y - x) % d == 0 && (y - x) / d + 1 <= n) {
                int a1 = x;
                for (int i = 0; i < n - ((y - x) / d + 1); ++i) {
                    if (a1 <= d) {
                        break;
                    }

                    a1 -= d;
                }

                int a1_ = a1;
                int d_ = d;
                return IntStream.range(0, n).mapToObj(i -> String.valueOf(a1_ + i * d_))
                        .collect(Collectors.joining(" "));
            }
        }
    }
}