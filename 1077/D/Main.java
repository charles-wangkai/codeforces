import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] s = new int[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.nextInt();
    }

    System.out.println(solve(s, k));

    sc.close();
  }

  static String solve(int[] s, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int si : s) {
      valueToCount.put(si, valueToCount.getOrDefault(si, 0) + 1);
    }

    int cutNum = -1;
    int lower = 1;
    int upper = s.length / k;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (valueToCount.values().stream().mapToInt(count -> count / middle).sum() >= k) {
        cutNum = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    int[] t = new int[k];
    int index = 0;
    for (int value : valueToCount.keySet()) {
      for (int i = 0; i < valueToCount.get(value) / cutNum; ++i) {
        if (index != t.length) {
          t[index] = value;
          ++index;
        }
      }
    }

    return Arrays.stream(t).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}