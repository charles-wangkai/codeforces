import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
        Arrays.sort(s);

        return IntStream.range(0, s.length - 1).map(i -> s[i + 1] - s[i]).min().getAsInt();
    }
}