import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(solve(n, k));
        }

        sc.close();
    }

    static int solve(int n, int k) {
        int result = -1;
        int lower = 1;
        int upper = 2 * k;
        while (lower <= upper) {
            int middle = lower + (upper - lower) / 2;
            int seq = middle - middle / n;
            if (seq < k) {
                lower = middle + 1;
            } else {
                if (seq == k) {
                    result = middle;
                }
                upper = middle - 1;
            }
        }

        return result;
    }
}