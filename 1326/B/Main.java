import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < b.length; ++i) {
            b[i] = sc.nextInt();
        }
        System.out.println(solve(b));

        sc.close();
    }

    static String solve(int[] b) {
        int x = 0;
        int[] a = new int[b.length];
        for (int i = 0; i < a.length; ++i) {
            a[i] = b[i] + x;
            x = Math.max(x, a[i]);
        }

        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}