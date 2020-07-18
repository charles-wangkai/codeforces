import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            System.out.println(solve(x, y, z));
        }

        sc.close();
    }

    static String solve(int x, int y, int z) {
        int[] sorted = IntStream.of(x, y, z).sorted().toArray();

        return (sorted[1] != sorted[2]) ? "NO" : String.format("YES\n1 %d %d", sorted[0], sorted[1]);
    }
}