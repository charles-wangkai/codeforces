import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int alpha = sc.nextInt();
        int beta = sc.nextInt();
        int gamma = sc.nextInt();
        int M = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solve(A, alpha, beta, gamma, M, k));

        sc.close();
    }

    static int solve(int A, int alpha, int beta, int gamma, int M, int k) {
        int[] indices = new int[M];
        Arrays.fill(indices, -1);

        List<Integer> values = new ArrayList<>();
        int current = A;
        values.add(current);
        for (int i = 1; i <= k; ++i) {
            current %= M;
            int next = (alpha * current * current + beta * current + gamma) % M;

            if (indices[next] != -1) {
                int period = i - indices[next];

                return values.get((k - indices[next]) % period + indices[next]);
            }

            indices[next] = i;
            values.add(next);

            current = next;
        }

        return current;
    }
}
