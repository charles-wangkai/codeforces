import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            long a1 = sc.nextLong();
            long K = sc.nextLong();

            System.out.println(solve(a1, K));
        }

        sc.close();
    }

    static long solve(long a1, long K) {
        long a = a1;
        while (K != 1) {
            --K;

            long next = computeNext(a);
            if (next == a) {
                break;
            }

            a = next;
        }

        return a;
    }

    static long computeNext(long a) {
        return a + String.valueOf(a).chars().map(ch -> ch - '0').min().getAsInt()
                * String.valueOf(a).chars().map(ch -> ch - '0').max().getAsInt();
    }
}