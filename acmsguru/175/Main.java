import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int q = sc.nextInt();

        System.out.println(solve(N, q));

        sc.close();
    }

    static int solve(int N, int q) {
        if (N == 1) {
            return 1;
        }

        int K = N / 2;
        if (q <= K) {
            return N - K + solve(K, K + 1 - q);
        } else {
            return solve(N - K, N + 1 - q);
        }
    }
}