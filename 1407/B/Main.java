import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[] a) {
        List<Integer> rests = Arrays.stream(a).boxed().collect(Collectors.toList());
        int[] b = new int[a.length];
        b[0] = rests.stream().max(Comparator.naturalOrder()).get();
        rests.remove((Integer) b[0]);
        int gcd = b[0];

        for (int i = 1; i < b.length; ++i) {
            int maxNextGcd = -1;
            int chosen = -1;
            for (int rest : rests) {
                int nextGcd = computeGcd(gcd, rest);
                if (nextGcd > maxNextGcd) {
                    maxNextGcd = nextGcd;
                    chosen = rest;
                }
            }

            gcd = maxNextGcd;
            b[i] = chosen;
            rests.remove((Integer) chosen);
        }

        return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static int computeGcd(int x, int y) {
        return (y == 0) ? x : computeGcd(y, x % y);
    }
}