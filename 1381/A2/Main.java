import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(String a, String b) {
    int n = a.length();

    List<Integer> operations = new ArrayList<>();
    char[] bits = a.toCharArray();
    int headIndex = 0;
    int offset = 1;
    boolean inverted = false;
    for (int i = n - 1; i >= 0; --i) {
      if (getBit(bits, headIndex, offset, inverted, i) != b.charAt(i)) {
        if (i != 0 && getBit(bits, headIndex, offset, inverted, 0) == b.charAt(i)) {
          operations.add(1);

          bits[headIndex] = invert(bits[headIndex]);
        }

        operations.add(i + 1);

        headIndex += offset * i;
        offset *= -1;
        inverted = !inverted;
      }
    }

    return String.format(
        "%d %s",
        operations.size(),
        operations.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static char getBit(char[] bits, int headIndex, int offset, boolean inverted, int index) {
    char original = bits[headIndex + offset * index];

    return inverted ? invert(original) : original;
  }

  static char invert(char bit) {
    return (char) ('0' + '1' - bit);
  }
}
