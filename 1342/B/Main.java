import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            String t = sc.next();

            System.out.println(solve(t));
        }

        sc.close();
    }

    static String solve(String t) {
        return (t.chars().distinct().count() == 1) ? t
                : IntStream.range(0, t.length()).mapToObj(i -> "01").collect(Collectors.joining());
    }
}