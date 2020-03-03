import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = readArray(sc, n);
            int[] p = readArray(sc, m);

            System.out.println(solve(a, p) ? "YES" : "NO");
        }

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static boolean solve(int[] a, int[] p) {
        boolean[] swappables = new boolean[a.length];
        for (int pi : p) {
            swappables[pi - 1] = true;
        }

        while (true) {
            boolean swapped = false;
            for (int i = 0; i < a.length - 1; ++i) {
                if (swappables[i] && a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return IntStream.range(0, a.length - 1).allMatch(i -> a[i] <= a[i + 1]);
    }
}