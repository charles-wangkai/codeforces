import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    static String solve(int[] a) {
        a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

        int leftIndex = (a.length - 1) / 2;
        int rightIndex = leftIndex + 1;
        boolean leftOrRight = true;
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; ++i) {
            if (leftOrRight) {
                result[i] = a[leftIndex];
                --leftIndex;
            } else {
                result[i] = a[rightIndex];
                ++rightIndex;
            }

            leftOrRight = !leftOrRight;
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}