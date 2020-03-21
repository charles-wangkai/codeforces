import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int MODULUS = 998_244_353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < p.length; ++i) {
            p[i] = sc.nextInt();
        }
        System.out.println(solve(p, k));

        sc.close();
    }

    static String solve(int[] p, int k) {
        int lower = p.length - k + 1;
        long partitionValue = (long) (lower + p.length) * k / 2;

        int[] indices = IntStream.range(0, p.length).filter(i -> p[i] >= lower).toArray();
        int segmentNum = IntStream.range(0, indices.length - 1).map(i -> indices[i + 1] - indices[i]).reduce(1,
                Main::multiplyMod);

        return String.format("%d %d", partitionValue, segmentNum);
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}