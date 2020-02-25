import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
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
        int[] neighbors = IntStream.range(0, a.length)
                .filter(i -> a[i] != -1 && ((i != 0 && a[i - 1] == -1) || (i != a.length - 1 && a[i + 1] == -1)))
                .map(i -> a[i]).toArray();

        if (neighbors.length == 0) {
            return "0 0";
        }

        int min = Arrays.stream(neighbors).min().getAsInt();
        int max = Arrays.stream(neighbors).max().getAsInt();

        int k = (min + max) / 2;
        int[] filled = IntStream.range(0, a.length).map(i -> (a[i] == -1) ? k : a[i]).toArray();
        int m = IntStream.range(0, filled.length - 1).map(i -> Math.abs(filled[i] - filled[i + 1])).max().getAsInt();

        return String.format("%d %d", m, k);
    }
}