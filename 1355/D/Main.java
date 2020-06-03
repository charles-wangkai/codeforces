import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        System.out.println(solve(N, S));

        sc.close();
    }

    static String solve(int N, int S) {
        if (N * 2 > S) {
            return "NO";
        }

        return String.format("YES\n%s\n1", IntStream.range(0, N)
                .mapToObj(i -> String.valueOf(S / N + (i < S % N ? 1 : 0))).collect(Collectors.joining(" ")));
    }
}