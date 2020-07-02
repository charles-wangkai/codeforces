import java.util.BitSet;
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

    static int solve(int[] a) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < a.length; ++i) {
            int sum = a[i];
            for (int j = i + 1; j < a.length; ++j) {
                sum += a[j];
                bitSet.set(sum);
            }
        }

        int result = 0;
        for (int ai : a) {
            if (bitSet.get(ai)) {
                ++result;
            }
        }

        return result;
    }
}