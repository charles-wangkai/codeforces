import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = readArray(sc, n);
            int[] b = readArray(sc, n);

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static String solve(int[] a, int[] b) {
        return String.format("%s\n%s",
                Arrays.stream(a).sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")),
                Arrays.stream(b).sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}