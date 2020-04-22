import java.util.Scanner;
import java.util.stream.Collectors;
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

    static String solve(int n) {
        if (n % 4 != 0) {
            return "NO";
        }

        return String.format("YES\n%s",
                IntStream
                        .concat(IntStream.range(0, n / 2).map(i -> i * 2 + 2),
                                IntStream.rangeClosed(0, n / 2).filter(i -> i != n / 4).map(i -> i * 2 + 1))
                        .mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}