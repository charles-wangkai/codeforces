import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < s.length; ++i) {
                s[i] = sc.nextInt();
            }

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(int[] s) {
        Set<Integer> set = Arrays.stream(s).boxed().collect(Collectors.toSet());

        for (int i = 1; i < 1024; ++i) {
            int i_ = i;
            if (set.stream().map(x -> x ^ i_).collect(Collectors.toSet()).equals(set)) {
                return i;
            }
        }

        return -1;
    }
}