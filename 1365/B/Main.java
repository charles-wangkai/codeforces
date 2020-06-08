import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = readArray(sc, n);
            int[] b = readArray(sc, n);

            System.out.println(solve(a, b) ? "Yes" : "No");
        }

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static boolean solve(int[] a, int[] b) {
        return Arrays.stream(b).distinct().count() == 2
                || IntStream.range(0, a.length - 1).allMatch(i -> a[i] <= a[i + 1]);
    }
}