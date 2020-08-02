import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solve(n, k));

        sc.close();
    }

    static BigInteger solve(int n, int k) {
        BigInteger[][] wayNums = new BigInteger[k + 1][1 << (n + 1)];
        for (int i = 0; i <= k; ++i) {
            Arrays.fill(wayNums[i], BigInteger.ZERO);
        }
        wayNums[0][0] = BigInteger.ONE;

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                BigInteger[][] nextWayNums = new BigInteger[k + 1][1 << (n + 1)];
                for (int i = 0; i <= k; ++i) {
                    Arrays.fill(nextWayNums[i], BigInteger.ZERO);
                }

                for (int i = 0; i <= k; ++i) {
                    for (int state = 0; state < 1 << (n + 1); ++state) {
                        int nextState = (state << 1) % (1 << (n + 1));
                        nextWayNums[i][nextState] = nextWayNums[i][nextState].add(wayNums[i][state]);

                        if (i != k && (c == 0 || ((state & 1) == 0 && (state & (1 << n)) == 0))
                                && (c == n - 1 || (state & (1 << (n - 2))) == 0) && (state & (1 << (n - 1))) == 0) {
                            nextWayNums[i + 1][nextState + 1] = nextWayNums[i + 1][nextState + 1]
                                    .add(wayNums[i][state]);
                        }
                    }
                }

                wayNums = nextWayNums;
            }
        }

        return Arrays.stream(wayNums[k]).reduce((x, y) -> x.add(y)).get();
    }
}