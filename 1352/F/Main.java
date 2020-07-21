import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n0 = sc.nextInt();
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            System.out.println(solve(n0, n1, n2));
        }

        sc.close();
    }

    static String solve(int n0, int n1, int n2) {
        if (n1 == 0) {
            if (n0 == 0) {
                return repeat(1, n2 + 1);
            } else {
                return repeat(0, n0 + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(repeat(0, n0 + 1));
        result.append(repeat(1, n2 + 1));
        for (int i = 0; i < n1 - 1; ++i) {
            result.append(i % 2);
        }

        return result.toString();
    }

    static String repeat(int value, int count) {
        return IntStream.range(0, count).mapToObj(i -> String.valueOf(value)).collect(Collectors.joining());
    }
}