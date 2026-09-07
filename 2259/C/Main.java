import java.util.Arrays;
import java.util.OptionalInt;
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
    int[] pendingIndices = IntStream.range(0, a.length).filter(i -> a[i] == -1).toArray();
    for (int pendingIndex : pendingIndices) {
      a[pendingIndex] = 0;
    }

    if (pendingIndices.length != 0) {
      OptionalInt firstOneIndex = IntStream.range(0, a.length).filter(i -> a[i] == 1).min();

      if (firstOneIndex.isPresent()) {
        int lastOneIndex = IntStream.range(0, a.length).filter(i -> a[i] == 1).max().getAsInt();

        if (pendingIndices[0] < firstOneIndex.getAsInt()) {
          a[pendingIndices[0]] = 1;
        }
        if (pendingIndices[pendingIndices.length - 1] > lastOneIndex) {
          a[pendingIndices[pendingIndices.length - 1]] = 1;
        }
      } else {
        a[pendingIndices[0]] = 1;
        a[pendingIndices[pendingIndices.length - 1]] = 1;
      }
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}