import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = sc.nextInt();
            }

            System.out.println(solve(p));
        }

        sc.close();
    }

    static String solve(int[] p) {
        return IntStream.range(0, p.length).mapToObj(i -> String.valueOf(p[p.length - 1 - i]))
                .collect(Collectors.joining(" "));
    }
}