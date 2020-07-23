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
        a = Arrays.stream(a).boxed().sorted().mapToInt(ai -> ai).toArray();

        int result = 0;
        int[] teamNums = new int[a.length];
        Arrays.fill(teamNums, -1);
        for (int i = teamNums.length - 1; i >= 0; --i) {
            int size = (x + a[i] - 1) / a[i];
            if (i + size <= teamNums.length) {
                teamNums[i] = 1 + ((i + size == teamNums.length) ? 0 : teamNums[i + size]);

                result = Math.max(result, teamNums[i]);
            }
        }

        return result;
    }
}