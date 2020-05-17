import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int N = sc.nextInt();
            int[] e = new int[N];
            for (int i = 0; i < e.length; ++i) {
                e[i] = sc.nextInt();
            }

            System.out.println(solve(e));
        }

        sc.close();
    }

    static int solve(int[] e) {
        e = Arrays.stream(e).boxed().sorted().mapToInt(x -> x).toArray();

        int result = 0;
        int count = 0;
        int maxNeeded = 0;
        for (int i = 0; i < e.length; ++i) {
            ++count;
            maxNeeded = Math.max(maxNeeded, e[i]);

            if (count == maxNeeded) {
                ++result;

                count = 0;
                maxNeeded = 0;
            }
        }

        return result;
    }
}