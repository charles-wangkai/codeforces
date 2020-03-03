import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }
        System.out.println(solve(a, m));

        sc.close();
    }

    static int solve(int[] a, int m) {
        int[] remainders = new int[m];
        Arrays.fill(remainders, -1);

        for (int ai : a) {
            if (remainders[ai % m] != -1) {
                return 0;
            }

            remainders[ai % m] = ai;
        }

        int result = 1;
        for (int i = 0; i < remainders.length; ++i) {
            for (int j = i + 1; j < remainders.length; ++j) {
                if (remainders[i] != -1 && remainders[j] != -1) {
                    result = (int) ((long) result * Math.abs(remainders[i] - remainders[j]) % m);
                }
            }
        }

        return result;
    }
}