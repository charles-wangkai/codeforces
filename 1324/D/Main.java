import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = readArray(sc, n);
        int[] b = readArray(sc, n);
        System.out.println(solve(a, b));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static long solve(int[] a, int[] b) {
        int[] sortedIndices = IntStream.range(0, a.length).boxed()
                .sorted((i1, i2) -> Integer.compare(a[i1] - b[i1], a[i2] - b[i2])).mapToInt(x -> x).toArray();

        return IntStream.range(0, a.length)
                .mapToLong(i -> computePairNum(a, b, sortedIndices, -a[i] + b[i]) - ((a[i] > b[i]) ? 1 : 0)).sum() / 2;
    }

    static int computePairNum(int[] a, int[] b, int[] sortedIndices, int minDiff) {
        int lowerIndex = 0;
        int upperIndex = sortedIndices.length - 1;
        int resultIndex = sortedIndices.length;
        while (lowerIndex <= upperIndex) {
            int middleIndex = (lowerIndex + upperIndex) / 2;
            int index = sortedIndices[middleIndex];
            if (a[index] - b[index] > minDiff) {
                resultIndex = middleIndex;
                upperIndex = middleIndex - 1;
            } else {
                lowerIndex = middleIndex + 1;
            }
        }

        return sortedIndices.length - resultIndex;
    }
}