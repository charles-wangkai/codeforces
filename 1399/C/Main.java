import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < w.length; ++i) {
                w[i] = sc.nextInt();
            }

            System.out.println(solve(w));
        }

        sc.close();
    }

    static int solve(int[] w) {
        int n = w.length;

        Arrays.sort(w);

        int result = 0;
        for (int sum = 2; sum <= n * 2; ++sum) {
            int teamCount = 0;
            int leftIndex = 0;
            int rightIndex = n - 1;
            while (leftIndex < rightIndex) {
                if (w[leftIndex] + w[rightIndex] < sum) {
                    ++leftIndex;
                } else if (w[leftIndex] + w[rightIndex] > sum) {
                    --rightIndex;
                } else {
                    ++teamCount;
                    ++leftIndex;
                    --rightIndex;
                }
            }

            result = Math.max(result, teamCount);
        }

        return result;
    }
}