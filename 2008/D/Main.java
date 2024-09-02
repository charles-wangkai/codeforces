import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      String s = sc.next();

      System.out.println(solve(p, s));
    }

    sc.close();
  }

  static String solve(int[] p, String s) {
    int[] result = new int[p.length];
    Arrays.fill(result, -1);

    for (int i = 0; i < result.length; ++i) {
      if (result[i] == -1) {
        int curr = i;
        List<Integer> indices = new ArrayList<>();
        Map<Integer, Integer> indexToPos = new HashMap<>();
        while (true) {
          indices.add(curr);
          indexToPos.put(curr, indexToPos.size());

          int next = p[curr] - 1;
          if (result[next] != -1) {
            for (int j = indices.size() - 1; j >= 0; --j) {
              result[indices.get(j)] =
                  result[p[indices.get(j)] - 1] + ((s.charAt(indices.get(j)) == '0') ? 1 : 0);
            }

            break;
          }
          if (indexToPos.containsKey(next)) {
            int beginPos = indexToPos.get(next);
            int blackCount =
                (int)
                    IntStream.range(beginPos, indices.size())
                        .filter(j -> s.charAt(indices.get(j)) == '0')
                        .count();
            for (int j = beginPos; j < indices.size(); ++j) {
              result[indices.get(j)] = blackCount;
            }
            for (int j = beginPos - 1; j >= 0; --j) {
              result[indices.get(j)] =
                  result[p[indices.get(j)] - 1] + ((s.charAt(indices.get(j)) == '0') ? 1 : 0);
            }

            break;
          }

          curr = next;
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}