import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int poundNum = (int) s.chars().filter(c -> c == '#').count();
    int needed =
        (int) s.chars().filter(c -> c == '(').count()
            - (int) s.chars().filter(c -> c == ')').count();
    if (needed < poundNum) {
      return "-1";
    }

    int[] result =
        IntStream.range(0, poundNum)
            .map(i -> (i == poundNum - 1) ? (needed - poundNum + 1) : 1)
            .toArray();

    int depth = 0;
    int pos = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        ++depth;
      } else if (c == ')') {
        --depth;
      } else {
        depth -= result[pos];
        ++pos;
      }

      if (depth < 0) {
        return "-1";
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}