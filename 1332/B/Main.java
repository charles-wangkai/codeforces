import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };

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
        int[] indices = Arrays.stream(a).map(x -> {
            for (int i = 0;; ++i) {
                if (x % PRIMES[i] == 0) {
                    return i;
                }
            }
        }).toArray();

        boolean[] used = new boolean[PRIMES.length];
        for (int index : indices) {
            used[index] = true;
        }

        int colorCount = 0;
        int[] indexToColor = new int[PRIMES.length];
        for (int i = 0; i < indexToColor.length; ++i) {
            if (used[i]) {
                ++colorCount;
                indexToColor[i] = colorCount;
            }
        }

        return String.format("%d\n%s", colorCount, Arrays.stream(indices)
                .mapToObj(index -> String.valueOf(indexToColor[index])).collect(Collectors.joining(" ")));
    }
}