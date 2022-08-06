import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static final int VALUE_LIMIT = 1_000_000;
  static final int N_LIMIT = 1000;

  static int[] counts = new int[VALUE_LIMIT + 1];
  static int[] decrements = new int[2 * N_LIMIT];

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder output = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[2 * n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      output.append(solve(a)).append("\n");
    }
    System.out.print(output);
  }

  static String solve(int[] a) {
    Arrays.sort(a);

    for (int ai : a) {
      ++counts[ai];
    }

    int[] candidates = Arrays.stream(a).distinct().toArray();

    for (int i = a.length - 2; i >= 0; --i) {
      int x = a[a.length - 1] + a[i];
      List<String> operations = findOperations(a, counts, candidates, x);
      if (operations != null) {
        for (int ai : a) {
          --counts[ai];
        }

        return String.format("YES\n%d\n%s", x, String.join("\n", operations));
      }
    }

    for (int ai : a) {
      --counts[ai];
    }

    return "NO";
  }

  static List<String> findOperations(int[] a, int[] counts, int[] candidates, int x) {
    List<String> result = new ArrayList<>();
    int index = candidates.length - 1;
    int decrementIndex = 0;
    for (int i = 0; i < a.length / 2; ++i) {
      while (counts[candidates[index]] == 0) {
        --index;
      }

      int value1 = candidates[index];
      --counts[value1];
      decrements[decrementIndex] = value1;
      ++decrementIndex;

      int value2 = x - value1;
      if (value2 < 0 || counts[value2] == 0) {
        for (int j = 0; j < decrementIndex; ++j) {
          ++counts[decrements[j]];
        }

        return null;
      }
      --counts[value2];
      decrements[decrementIndex] = value2;
      ++decrementIndex;

      result.add(value1 + " " + value2);
      x = value1;
    }

    for (int j = 0; j < decrementIndex; ++j) {
      ++counts[decrements[j]];
    }

    return result;
  }
}