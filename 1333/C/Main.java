import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static long solve(int[] a) {
        long result = 0;
        int beginIndex = -1;
        long beginSum = 0;
        long endSum = 0;
        Set<Long> sums = new HashSet<>();
        sums.add(beginSum);
        for (int endIndex = 0; endIndex < a.length; ++endIndex) {
            endSum += a[endIndex];
            while (sums.contains(endSum)) {
                sums.remove(beginSum);
                ++beginIndex;
                beginSum += a[beginIndex];
            }

            result += endIndex - beginIndex;
            sums.add(endSum);
        }

        return result;
    }
}