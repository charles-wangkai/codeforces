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

    static int solve(int[] a) {
        int wrongNumWithEvenIndices = (int) IntStream.range(0, a.length).filter(i -> i % 2 == 0 && a[i] % 2 != 0)
                .count();
        int wrongNumWithOddIndices = (int) IntStream.range(0, a.length).filter(i -> i % 2 != 0 && a[i] % 2 == 0)
                .count();

        return (wrongNumWithEvenIndices != wrongNumWithOddIndices) ? -1 : wrongNumWithEvenIndices;
    }
}