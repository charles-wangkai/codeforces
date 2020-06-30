import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        if (n <= 3) {
            return "-1";
        }
        if (n == 4) {
            return "3 1 4 2";
        }

        List<Integer> result = new ArrayList<>();
        int p = 1;
        while (p <= n) {
            result.add(p);
            p += 2;
        }

        p -= 5;
        result.add(p);

        if (p + 4 <= n) {
            result.add(p + 4);
        }
        result.add(p + 2);
        p -= 2;

        while (p >= 1) {
            result.add(p);
            p -= 2;
        }

        return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}