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
            int x = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, x));
        }

        sc.close();
    }

    static int solve(int[] a, int x) {
        Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());
        for (int i = 1;; ++i) {
            if (!aSet.contains(i)) {
                if (x == 0) {
                    return i - 1;
                }

                --x;
            }
        }
    }
}