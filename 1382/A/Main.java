import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
            int[] b = new int[m];
            for (int i = 0; i < b.length; ++i) {
                b[i] = sc.nextInt();
            }

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static String solve(int[] a, int[] b) {
        Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        for (int bi : b) {
            if (setA.contains(bi)) {
                return String.format("YES\n1 %d", bi);
            }
        }

        return "NO";
    }
}