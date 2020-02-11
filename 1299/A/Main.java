import java.util.Arrays;
import java.util.List;
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
        for (int i = 30; i >= 0; --i) {
            int mask = 1 << i;
            int[] values = Arrays.stream(a).filter(x -> (x & mask) != 0).toArray();
            if (values.length == 1) {
                List<Integer> rest = Arrays.stream(a).boxed().collect(Collectors.toList());
                rest.remove(Integer.valueOf(values[0]));

                return String.format("%d %s", values[0],
                        rest.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }

        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}