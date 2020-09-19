import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    static long solve(int[] a) {
        long result = Long.MIN_VALUE;

        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        for (int ai : a) {
            if (ai < 0) {
                negatives.add(ai);
            } else if (ai > 0) {
                positives.add(ai);
            } else {
                result = 0;
            }
        }

        Collections.sort(negatives);
        Collections.sort(positives);

        for (int i = 0; i <= 5; ++i) {
            if (positives.size() >= i && negatives.size() >= 5 - i) {
                if (i % 2 == 0) {
                    result = Math.max(result,
                            mutiply(positives, 0, i) * mutiply(negatives, negatives.size() - (5 - i), 5 - i));
                } else {
                    result = Math.max(result,
                            mutiply(positives, positives.size() - i, i) * mutiply(negatives, 0, 5 - i));
                }
            }
        }

        return result;
    }

    static long mutiply(List<Integer> values, int beginIndex, int count) {
        return IntStream.range(beginIndex, beginIndex + count).map(values::get).asLongStream().reduce(1,
                (x, y) -> x * y);
    }
}