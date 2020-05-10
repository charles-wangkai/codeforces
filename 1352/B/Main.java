import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(solve(n, k));
        }

        sc.close();
    }

    static String solve(int n, int k) {
        if (n >= k && n % 2 == k % 2) {
            return String.format("YES\n%s", IntStream.range(0, k)
                    .mapToObj(i -> String.valueOf((i == 0) ? (n - (k - 1)) : 1)).collect(Collectors.joining(" ")));
        }
        if (n >= k * 2 && n % 2 == 0) {
            return String.format("YES\n%s", IntStream.range(0, k)
                    .mapToObj(i -> String.valueOf((i == 0) ? (n - (k - 1) * 2) : 2)).collect(Collectors.joining(" ")));
        }

        return "NO";
    }
}