import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static final int SIZE = 51;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[] a) {
        String[] result = new String[a.length + 1];
        result[0] = IntStream.range(0, SIZE).mapToObj(i -> "a").collect(Collectors.joining());
        for (int i = 1; i < result.length; ++i) {
            result[i] = String.format("%s%c%s", result[i - 1].substring(0, a[i - 1]),
                    (char) ((result[i - 1].charAt(a[i - 1]) - 'a' + 1) % 26 + 'a'),
                    result[i - 1].substring(a[i - 1] + 1));
        }

        return String.join("\n", result);
    }
}