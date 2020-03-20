import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();

            System.out.println(solve(n));
        }

        sc.close();
    }

    static String solve(int n) {
        return (n == 1) ? "-1"
                : String.format("2%s", IntStream.range(0, n - 1).mapToObj(i -> "3").collect(Collectors.joining()));
    }
}