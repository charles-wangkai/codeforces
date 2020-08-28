import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            String s = sc.next();

            System.out.println(solve(n, s));
        }

        sc.close();
    }

    static String solve(int n, String s) {
        return IntStream.range(0, n).mapToObj(i -> String.valueOf(s.charAt(n - 1))).collect(Collectors.joining());
    }
}