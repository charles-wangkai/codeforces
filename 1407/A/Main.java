import java.util.ArrayList;
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
        List<Integer> remains = new ArrayList<>();
        for (int i = 0; i < a.length; i += 2) {
            if (a[i] == a[i + 1]) {
                remains.add(a[i]);
                remains.add(a[i + 1]);
            } else {
                remains.add(0);
            }
        }

        return String.format("%d\n%s", remains.size(),
                remains.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}