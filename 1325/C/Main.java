import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] u = new int[n - 1];
        int[] v = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        System.out.println(solve(u, v));

        sc.close();
    }

    static String solve(int[] u, int[] v) {
        int n = u.length + 1;

        int[] degrees = new int[n + 1];
        for (int i = 0; i < u.length; ++i) {
            ++degrees[u[i]];
            ++degrees[v[i]];
        }

        int[] sortedIndices = IntStream.range(0, u.length).boxed().sorted((i1, i2) -> Integer
                .compare(Math.min(degrees[u[i1]], degrees[v[i1]]), Math.min(degrees[u[i2]], degrees[v[i2]])))
                .mapToInt(x -> x).toArray();

        int[] result = new int[u.length];
        for (int i = 0; i < result.length; ++i) {
            result[sortedIndices[i]] = i;
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}