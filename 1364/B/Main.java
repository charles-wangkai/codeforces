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
            int[] p = new int[n];
            for (int i = 0; i < p.length; ++i) {
                p[i] = sc.nextInt();
            }

            System.out.println(solve(p));
        }

        sc.close();
    }

    static String solve(int[] p) {
        List<Integer> result = new ArrayList<>();
        for (int pi : p) {
            if (result.size() >= 2 && (pi > result.get(result.size() - 1)) == (result.get(result.size() - 1) > result
                    .get(result.size() - 2))) {
                result.remove(result.size() - 1);
            }

            result.add(pi);
        }

        return String.format("%d\n%s", result.size(),
                result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}