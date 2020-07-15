import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < p.length; ++i) {
                p[i] = sc.nextInt();
            }

            System.out.println(solve(p));
        }

        sc.close();
    }

    static String solve(int[] p) {
        int n = p.length;

        int[] leftIndices = new int[n];
        int leftIndex = 0;
        for (int i = 1; i < leftIndices.length; ++i) {
            if (p[i] < p[leftIndex]) {
                leftIndex = i;
            }

            leftIndices[i] = leftIndex;
        }

        int[] rightIndices = new int[n];
        rightIndices[n - 1] = n - 1;
        int rightIndex = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (p[i] < p[rightIndex]) {
                rightIndex = i;
            }

            rightIndices[i] = rightIndex;
        }

        for (int i = 0; i < n; ++i) {
            if (leftIndices[i] != i && rightIndices[i] != i) {
                return String.format("YES\n%d %d %d", leftIndices[i] + 1, i + 1, rightIndices[i] + 1);
            }
        }

        return "NO";
    }
}