import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[2 * n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[] a) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int ai : a) {
            if (!seen.contains(ai)) {
                result.add(ai);
                seen.add(ai);
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}