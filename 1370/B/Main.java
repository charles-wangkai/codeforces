import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[2 * n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[] a) {
        int[] evenIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 0).toArray();
        int[] oddIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 != 0).toArray();

        int evenIndex = 0;
        int oddIndex = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < a.length / 2 - 1; ++i) {
            if (oddIndex + 1 < oddIndices.length) {
                result.add(String.format("%d %d", oddIndices[oddIndex] + 1, oddIndices[oddIndex + 1] + 1));
                oddIndex += 2;
            } else {
                result.add(String.format("%d %d", evenIndices[evenIndex] + 1, evenIndices[evenIndex + 1] + 1));
                evenIndex += 2;
            }
        }

        return String.join("\n", result);
    }
}