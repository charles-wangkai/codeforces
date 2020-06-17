import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String b = sc.next();

            System.out.println(solve(b));
        }

        sc.close();
    }

    static String solve(String b) {
        return IntStream.range(0, b.length()).filter(i -> i == 0 || i % 2 != 0)
                .mapToObj(i -> String.valueOf(b.charAt(i))).collect(Collectors.joining());
    }
}