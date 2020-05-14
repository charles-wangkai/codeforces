import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = readArray(sc, n);
            int[] b = readArray(sc, n);

            System.out.println(solve(a, b, k));
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

    static int solve(int[] a, int[] b, int k) {
        return Arrays.stream(a).sorted().skip(k).sum()
                + IntStream.concat(Arrays.stream(a).sorted().limit(k), Arrays.stream(b).sorted().skip(a.length - k))
                        .sorted().skip(k).sum();
    }
}