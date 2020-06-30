import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int n = a.length;

        List<String> solutions = new ArrayList<>();

        int[] counts = new int[n];
        for (int ai : a) {
            ++counts[ai];
        }

        int minLength = 0;
        while (minLength + 1 != counts.length && counts[minLength + 1] == 2) {
            ++minLength;
        }

        int maxLength = n - minLength;

        if (minLength != 0) {
            if (isPermutation(a, 0, minLength - 1) && isPermutation(a, minLength, n - 1)) {
                solutions.add(String.format("%d %d", minLength, maxLength));
            }
            if (minLength != maxLength && isPermutation(a, 0, maxLength - 1) && isPermutation(a, maxLength, n - 1)) {
                solutions.add(String.format("%d %d", maxLength, minLength));
            }
        }

        return String.format("%d%s", solutions.size(),
                solutions.stream().map(solution -> String.format("\n%s", solution)).collect(Collectors.joining()));
    }

    static boolean isPermutation(int[] a, int beginIndex, int endIndex) {
        int length = endIndex - beginIndex + 1;

        return IntStream.rangeClosed(beginIndex, endIndex).map(i -> a[i]).filter(x -> x >= 1 && x <= length).distinct()
                .count() == length;
    }
}