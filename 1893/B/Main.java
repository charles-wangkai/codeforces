import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int[] bSorted =
        Arrays.stream(b)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    int bIndex = 0;

    List<Integer> result = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();
    for (int ai : a) {
      int index = findFirstGreaterEqualIndex(sequence, ai);
      if (index >= sequence.size() - 1) {
        while (bIndex != bSorted.length && bSorted[bIndex] >= ai) {
          result.add(bSorted[bIndex]);
          ++bIndex;
        }
      }

      if (index == sequence.size()) {
        sequence.add(ai);
      } else {
        sequence.set(index, ai);
      }

      result.add(ai);
    }

    while (bIndex != bSorted.length) {
      result.add(bSorted[bIndex]);
      ++bIndex;
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  static int findFirstGreaterEqualIndex(List<Integer> subsequence, int target) {
    int result = subsequence.size();
    int lower = 0;
    int upper = subsequence.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (subsequence.get(middle) >= target) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}