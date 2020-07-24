import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] t = new int[n];
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; ++i) {
            t[i] = sc.nextInt();
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        System.out.println(solve(t, a, b, k));

        sc.close();
    }

    static int solve(int[] t, int[] a, int[] b, int k) {
        PriorityQueue<Integer> onlyAs = new PriorityQueue<>();
        PriorityQueue<Integer> onlyBs = new PriorityQueue<>();
        PriorityQueue<Integer> boths = new PriorityQueue<>();
        for (int i = 0; i < t.length; ++i) {
            if (a[i] == 1) {
                if (b[i] == 1) {
                    boths.offer(t[i]);
                } else {
                    onlyAs.offer(t[i]);
                }
            } else {
                if (b[i] == 1) {
                    onlyBs.offer(t[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < k; ++i) {
            if (boths.isEmpty() && (onlyAs.isEmpty() || onlyBs.isEmpty())) {
                return -1;
            }

            if (!boths.isEmpty()
                    && (onlyAs.isEmpty() || onlyBs.isEmpty() || boths.peek() <= onlyAs.peek() + onlyBs.peek())) {
                result += boths.poll();
            } else {
                result += onlyAs.poll() + onlyBs.poll();
            }
        }

        return result;
    }
}