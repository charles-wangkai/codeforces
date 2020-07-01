import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] u = new int[n - 1];
            int[] v = new int[n - 1];
            for (int i = 0; i < n - 1; ++i) {
                u[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }

            System.out.println(solve(u, v, x));
        }

        sc.close();
    }

    static String solve(int[] u, int[] v, int x) {
        return (IntStream.range(0, u.length).filter(i -> u[i] == x || v[i] == x).count() <= 1 || u.length % 2 != 0)
                ? "Ayush"
                : "Ashish";
    }
}