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

            System.out.println(solve(a) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[] a) {
        int[] evens = Arrays.stream(a).filter(x -> x % 2 == 0).toArray();
        int[] odds = Arrays.stream(a).filter(x -> x % 2 != 0).toArray();

        return evens.length % 2 == 0 || Arrays.stream(evens)
                .anyMatch(even -> Arrays.stream(odds).anyMatch(odd -> Math.abs(even - odd) == 1));
    }
}