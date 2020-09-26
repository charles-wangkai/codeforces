import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(String s) {
        return ((s.length() % 2 == 0
                && IntStream.range(0, s.length()).filter(i -> i % 2 != 0).allMatch(i -> (s.charAt(i) - '0') % 2 != 0))
                || (s.length() % 2 != 0 && IntStream.range(0, s.length()).filter(i -> i % 2 == 0)
                        .anyMatch(i -> (s.charAt(i) - '0') % 2 != 0))) ? 1 : 2;
    }
}