import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, k));
        }

        sc.close();
    }

    static String solve(int[] a, int k) {
        int[] period = Arrays.stream(a).distinct().toArray();
        if (period.length > k) {
            return "-1";
        }

        int index = 0;
        List<Integer> b = new ArrayList<>();
        while (index != a.length) {
            int target = period[Math.min(b.size() % k, period.length - 1)];
            if (a[index] == target) {
                ++index;
            }

            b.add(target);
        }

        return String.format("%d\n%s", b.size(), b.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}