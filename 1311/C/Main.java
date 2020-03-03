import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            int[] p = new int[m];
            for (int i = 0; i < p.length; ++i) {
                p[i] = sc.nextInt();
            }

            System.out.println(solve(s, p));
        }

        sc.close();
    }

    static String solve(String s, int[] p) {
        int[] lengths = IntStream.concat(Arrays.stream(p), IntStream.of(s.length())).sorted().toArray();
        int[] totals = new int[26];
        int[] counts = new int[26];
        for (int i = 0; i < lengths.length; ++i) {
            for (int j = (i == 0) ? 0 : lengths[i - 1]; j < lengths[i]; ++j) {
                ++counts[s.charAt(j) - 'a'];
            }

            for (int j = 0; j < totals.length; ++j) {
                totals[j] += counts[j];
            }
        }

        return Arrays.stream(totals).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}