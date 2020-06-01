import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, x) ? "Yes" : "No");
        }

        sc.close();
    }

    static boolean solve(int[] a, int x) {
        int oddCount = (int) Arrays.stream(a).filter(ai -> ai % 2 != 0).count();

        if (oddCount == 0) {
            return false;
        }
        if (oddCount == a.length) {
            return x % 2 != 0;
        }
        if (x == a.length) {
            return oddCount % 2 != 0;
        }

        return true;
    }
}