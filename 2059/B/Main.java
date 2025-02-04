import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    Map<Integer, Integer> sequenceToBeginIndex = buildSequenceToBeginIndex(a.length, k);
    Map<Integer, Integer> sequenceToEndIndex = buildSequenceToEndIndex(a.length, k);

    for (int i = 0; i < k / 2; ++i) {
      int i_ = i;
      if (IntStream.rangeClosed(sequenceToBeginIndex.get(i), sequenceToEndIndex.get(i))
          .anyMatch(index -> a[index] != i_ + 1)) {
        return i + 1;
      }
    }

    return k / 2 + 1;
  }

  static Map<Integer, Integer> buildSequenceToBeginIndex(int n, int k) {
    boolean[] excluded = new boolean[n];
    excluded[0] = true;
    for (int i = 0; i < k / 2 - 1; ++i) {
      excluded[excluded.length - 2 - i * 2] = true;
    }

    return buildSequenceToIndex(excluded);
  }

  static Map<Integer, Integer> buildSequenceToEndIndex(int n, int k) {
    boolean[] excluded = new boolean[n];
    Arrays.fill(excluded, true);
    for (int i = 0; i < k / 2; ++i) {
      excluded[excluded.length - 1 - i * 2] = false;
    }

    return buildSequenceToIndex(excluded);
  }

  static Map<Integer, Integer> buildSequenceToIndex(boolean[] excluded) {
    Map<Integer, Integer> result = new HashMap<>();
    int sequence = 0;
    for (int i = 0; i < excluded.length; ++i) {
      if (!excluded[i]) {
        result.put(sequence, i);
        ++sequence;
      }
    }

    return result;
  }
}
