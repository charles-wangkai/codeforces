import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] leftIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '(').toArray();
    int[] rightIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == ')').toArray();
    if (leftIndices.length != rightIndices.length) {
      return "-1";
    }

    if (isRegular(s) || isRegular(new StringBuilder(s).reverse().toString())) {
      return String.format(
          "1\n%s",
          IntStream.range(0, s.length())
              .map(i -> 1)
              .mapToObj(String::valueOf)
              .collect(Collectors.joining(" ")));
    }

    int colorNum = 0;
    int[] c = new int[s.length()];
    Boolean prevOrder = null;
    for (int i = 0; i < leftIndices.length; ++i) {
      boolean order = leftIndices[i] < rightIndices[rightIndices.length - 1 - i];
      if (!Objects.equals(order, prevOrder)) {
        ++colorNum;
      }

      c[leftIndices[i]] = colorNum;
      c[rightIndices[rightIndices.length - 1 - i]] = colorNum;

      prevOrder = order;
    }

    return String.format(
        "%d\n%s",
        colorNum, Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static boolean isRegular(String str) {
    int depth = 0;
    for (char c : str.toCharArray()) {
      if (c == '(') {
        ++depth;
      } else {
        if (depth == 0) {
          return false;
        }

        --depth;
      }
    }

    return true;
  }
}
