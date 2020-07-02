import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            System.out.println(solve(s, k));
        }

        sc.close();
    }

    static String solve(String s, int k) {
        int n = s.length();

        s = s.chars().sorted().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());

        if (k == 1) {
            return s;
        }
        if (s.charAt(0) != s.charAt(k - 1)) {
            return String.valueOf(s.charAt(k - 1));
        }
        if (k == n) {
            return String.valueOf(s.charAt(0));
        }
        if (s.charAt(k) != s.charAt(n - 1)) {
            return String.format("%c%s", s.charAt(0), s.substring(k));
        }

        return String.format("%c%s", s.charAt(0), repeat(s.charAt(k), (n - 1) / k));
    }

    static String repeat(char ch, int count) {
        return IntStream.range(0, count).mapToObj(i -> String.valueOf(ch)).collect(Collectors.joining());
    }
}