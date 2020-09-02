import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static String solve(String s) {
        int k = 0;
        Queue<Integer> lastZeros = new LinkedList<>();
        Queue<Integer> lastOnes = new LinkedList<>();

        int[] a = new int[s.length()];
        for (int i = 0; i < a.length; ++i) {
            int digit = s.charAt(i) - '0';
            if (digit == 0) {
                if (lastOnes.isEmpty()) {
                    ++k;
                    lastOnes.offer(k);
                }

                a[i] = lastOnes.poll();
                lastZeros.offer(a[i]);
            } else {
                if (lastZeros.isEmpty()) {
                    ++k;
                    lastZeros.offer(k);
                }

                a[i] = lastZeros.poll();
                lastOnes.offer(a[i]);
            }
        }

        return String.format("%d\n%s", k, Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}