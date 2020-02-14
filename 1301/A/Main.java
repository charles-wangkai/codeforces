import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();

            System.out.println(solve(a, b, c) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(String a, String b, String c) {
        return IntStream.range(0, c.length()).allMatch(i -> c.charAt(i) == a.charAt(i) || c.charAt(i) == b.charAt(i));
    }
}