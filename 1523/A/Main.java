import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int[] OFFSETS = {-1, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, m));
    }

    sc.close();
  }

  static String solve(String s, int m) {
    int n = s.length();

    char[] cells = s.toCharArray();
    Set<Integer> indices =
        IntStream.range(0, n).filter(i -> cells[i] == '1').boxed().collect(Collectors.toSet());

    for (int i = 0; i < m && !indices.isEmpty(); ++i) {
      Set<Integer> nextIndices = new HashSet<>();
      for (int index : indices) {
        for (int offset : OFFSETS) {
          int nextIndex = index + offset;
          if (nextIndex >= 0
              && nextIndex < n
              && cells[nextIndex] == '0'
              && ((nextIndex != 0 && cells[nextIndex - 1] == '1') ? 1 : 0)
                      + ((nextIndex != n - 1 && cells[nextIndex + 1] == '1') ? 1 : 0)
                  == 1) {
            nextIndices.add(nextIndex);
          }
        }
      }

      indices = nextIndices;
      for (int index : indices) {
        cells[index] = '1';
      }
    }

    return new String(cells);
  }
}
