import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    static String solve(int[] a) {
        int[] sorted = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

        int index = 0;
        int offset = 2;
        int[] reordered = new int[a.length];
        for (int i = 0; i < sorted.length; ++i) {
            if (index >= reordered.length) {
                index = (a.length % 2 == 0) ? (reordered.length - 1) : (reordered.length - 2);
                offset = -2;
            }

            reordered[index] = sorted[i];

            index += offset;
        }

        return String.format("%d\n%s", (a.length - 1) / 2,
                Arrays.stream(reordered).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}