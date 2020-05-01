import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();

            System.out.println(solve(n));
        }

        sc.close();
    }

    static int solve(int n) {
        return ((1 << n) + IntStream.rangeClosed(1, n / 2 - 1).map(i -> 1 << i).sum())
                - IntStream.rangeClosed(n / 2, n - 1).map(i -> 1 << i).sum();
    }
}