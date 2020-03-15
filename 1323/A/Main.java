import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[] a) {
        OptionalInt evenIndex = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 0).findAny();
        if (evenIndex.isPresent()) {
            return String.format("1\n%d", evenIndex.getAsInt() + 1);
        }

        if (a.length == 1) {
            return "-1";
        }

        return "2\n1 2";
    }
}