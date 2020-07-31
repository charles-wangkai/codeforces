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
        int count8 = (n + 3) / 4;
        int count9 = n - count8;

        return String.format("%s%s", repeat('9', count9), repeat('8', count8));
    }

    static String repeat(char ch, int count) {
        return IntStream.range(0, count).mapToObj(i -> String.valueOf(ch)).collect(Collectors.joining());
    }
}