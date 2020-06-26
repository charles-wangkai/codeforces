import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }
            int[] w = new int[k];
            for (int i = 0; i < w.length; ++i) {
                w[i] = sc.nextInt();
            }

            System.out.println(solve(a, w));
        }

        sc.close();
    }

    static long solve(int[] a, int[] w) {
        a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
        w = Arrays.stream(w).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

        int leftIndex = 0;
        int rightIndex = a.length - w.length;
        long result = 0;
        for (int wi : w) {
            if (wi == 1) {
                result += a[rightIndex];
            } else {
                result += a[leftIndex];
                leftIndex += wi - 1;
            }

            result += a[rightIndex];
            ++rightIndex;
        }

        return result;
    }
}