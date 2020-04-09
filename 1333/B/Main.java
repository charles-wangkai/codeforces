import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = readArray(sc, n);
            int[] b = readArray(sc, n);

            System.out.println(solve(a, b) ? "YES" : "NO");
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

    static boolean solve(int[] a, int[] b) {
        boolean neg = false;
        boolean pos = false;
        for (int i = 0; i < a.length; ++i) {
            if ((b[i] < a[i] && !neg) || (b[i] > a[i] && !pos)) {
                return false;
            }

            if (a[i] == -1) {
                neg = true;
            } else if (a[i] == 1) {
                pos = true;
            }
        }

        return true;
    }
}