import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; ++tc) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(br.readLine());
                a[i] = Long.parseLong(st.nextToken());
                b[i] = Long.parseLong(st.nextToken());
            }

            result.append(solve(a, b)).append("\n");
        }
        System.out.print(result);

        br.close();
    }

    static long solve(long[] a, long[] b) {
        int n = a.length;

        long bulletNum = a[0];
        for (int i = 1; i < n; ++i) {
            bulletNum += Math.max(0, a[i] - b[i - 1]);
        }

        long result = bulletNum;
        for (int i = 1; i < n; ++i) {
            bulletNum += a[i] - a[i - 1] - Math.max(0, a[i] - b[i - 1]) + Math.max(0, a[i - 1] - b[(i - 2 + n) % n]);
            result = Math.min(result, bulletNum);
        }

        return result;
    }
}