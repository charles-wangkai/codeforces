import java.util.Arrays;
import java.util.Scanner;

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

    static int solve(int[] a) {
        int zeroCount = (int) Arrays.stream(a).filter(x -> x == 0).count();

        return zeroCount + ((Arrays.stream(a).sum() + zeroCount == 0) ? 1 : 0);
    }
}