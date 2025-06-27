import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] h = new int[n];
    for (int i = 0; i < h.length; ++i) {
      h[i] = sc.nextInt();
    }

    System.out.println(solve(h));

    sc.close();
  }

  static String solve(int[] h) {
    int[] sortedIndices =
        IntStream.range(0, h.length)
            .boxed()
            .sorted(Comparator.comparing(i -> h[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] samePositions =
        IntStream.range(0, sortedIndices.length - 1)
            .filter(i -> h[sortedIndices[i]] == h[sortedIndices[i + 1]])
            .toArray();
    if (samePositions.length <= 1) {
      return "NO";
    }

    List<String> sequences = new ArrayList<>();
    sequences.add(buildSequence(sortedIndices));
    for (int i = 0; i < 2; ++i) {
      swap(sortedIndices, samePositions[i], samePositions[i] + 1);
      sequences.add(buildSequence(sortedIndices));
      swap(sortedIndices, samePositions[i], samePositions[i] + 1);
    }

    return "YES\n%s".formatted(String.join("\n", sequences));
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static String buildSequence(int[] sortedIndices) {
    return Arrays.stream(sortedIndices)
        .map(x -> x + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}