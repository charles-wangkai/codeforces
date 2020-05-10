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
        List<Integer> terms = new ArrayList<>();
        for (int i = 10000; i >= 1; i /= 10) {
            int term = n / i * i;
            if (term != 0) {
                terms.add(term);
                n -= term;
            }
        }

        return String.format("%d\n%s", terms.size(),
                terms.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}