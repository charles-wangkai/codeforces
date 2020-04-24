import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, k));
        }

        sc.close();
    }

    static String solve(int[] a, int k) {
        boolean[] peaks = new boolean[a.length];
        for (int i = 1; i < a.length - 1; ++i) {
            peaks[i] = a[i] > a[i - 1] && a[i] > a[i + 1];
        }

        int l = 1;
        int peakNum = (int) IntStream.range(1, k - 2).filter(i -> peaks[i]).count();
        int maxPeakNum = peakNum;
        for (int i = k - 1; i < peaks.length; ++i) {
            if (peaks[i - 1]) {
                ++peakNum;

                if (peakNum > maxPeakNum) {
                    maxPeakNum = peakNum;
                    l = i - k + 2;
                }
            }

            if (peaks[i - k + 2]) {
                --peakNum;
            }
        }

        return String.format("%d %d", maxPeakNum + 1, l);
    }
}