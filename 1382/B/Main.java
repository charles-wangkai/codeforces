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

    static String solve(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != 1) {
                return (i % 2 == 0) ? "First" : "Second";
            }
        }

        return (a.length % 2 != 0) ? "First" : "Second";
    }
}