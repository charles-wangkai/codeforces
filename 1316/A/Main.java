import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, m));
        }

        sc.close();
    }

    static int solve(int[] a, int m) {
        return a[0] + Math.min(m - a[0], IntStream.range(1, a.length).map(i -> a[i]).sum());
    }
}