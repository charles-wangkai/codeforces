import java.util.Arrays;
import java.util.Scanner;

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
        int[] minIndices = new int[x];
        Arrays.fill(minIndices, Integer.MAX_VALUE);
        minIndices[0] = -1;

        int modWithMinIndex = 0;
        int modWithSecondMinIndex = -1;
        int result = -1;
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum = (sum + a[i]) % x;

            if (sum != modWithMinIndex) {
                result = Math.max(result, i - minIndices[modWithMinIndex]);

                if (modWithSecondMinIndex == -1) {
                    modWithSecondMinIndex = sum;
                }
            } else if (modWithSecondMinIndex != -1) {
                result = Math.max(result, i - minIndices[modWithSecondMinIndex]);
            }

            if (minIndices[sum] == Integer.MAX_VALUE) {
                minIndices[sum] = i;
            }
        }

        return result;
    }
}