import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int maxDepth = computeMaxDepth(s);

    int row = maxDepth * 2 + 1;
    int col =
        s.length()
            + (int)
                    IntStream.range(0, s.length() - 1)
                        .filter(i -> s.charAt(i) == '[' && s.charAt(i + 1) == ']')
                        .count()
                * 3;

    char[][] result = new char[row][col];
    for (int r = 0; r < row; ++r) {
      Arrays.fill(result[r], ' ');
    }

    int cIndex = -1;
    int depth = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '[') {
        ++cIndex;

        result[depth][cIndex] = '+';
        result[depth][cIndex + 1] = '-';
        result[row - 1 - depth][cIndex] = '+';
        result[row - 1 - depth][cIndex + 1] = '-';
        for (int r = depth + 1; r < row - 1 - depth; ++r) {
          result[r][cIndex] = '|';
        }

        ++depth;
      } else {
        --depth;

        if (s.charAt(i - 1) == ']') {
          ++cIndex;
        } else {
          cIndex += 4;
        }

        result[depth][cIndex] = '+';
        result[depth][cIndex - 1] = '-';
        result[row - 1 - depth][cIndex] = '+';
        result[row - 1 - depth][cIndex - 1] = '-';
        for (int r = depth + 1; r < row - 1 - depth; ++r) {
          result[r][cIndex] = '|';
        }
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int computeMaxDepth(String s) {
    int result = 0;
    int depth = 0;
    for (char c : s.toCharArray()) {
      depth += (c == '[') ? 1 : -1;
      result = Math.max(result, depth);
    }

    return result;
  }
}