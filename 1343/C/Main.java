import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static long solve(int[] a) {
        List<Integer> subsequence = new ArrayList<>();
        for (int ai : a) {
            if (subsequence.isEmpty()) {
                subsequence.add(ai);
            } else {
                int last = subsequence.get(subsequence.size() - 1);

                if (Integer.signum(ai) == Integer.signum(last)) {
                    subsequence.set(subsequence.size() - 1, Math.max(ai, last));
                } else {
                    subsequence.add(ai);
                }
            }
        }

        return subsequence.stream().mapToLong(x -> x).sum();
    }
}