import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();

            System.out.println(solve(n));
        }

        sc.close();
    }

    static String solve(int n) {
        int[] result = new int[n];

        PriorityQueue<Range> pq = new PriorityQueue<>((r1, r2) -> (r1.end - r1.begin != r2.end - r2.begin)
                ? -Integer.compare(r1.end - r1.begin, r2.end - r2.begin)
                : Integer.compare(r1.begin, r2.begin));
        pq.offer(new Range(0, n - 1));

        for (int i = 0; i < n; ++i) {
            Range range = pq.poll();
            int middle = (range.begin + range.end) / 2;
            result[middle] = i + 1;

            if (range.begin <= middle - 1) {
                pq.offer(new Range(range.begin, middle - 1));
            }
            if (middle + 1 <= range.end) {
                pq.offer(new Range(middle + 1, range.end));
            }
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}

class Range {
    int begin;
    int end;

    Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}