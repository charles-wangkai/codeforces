import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int[] indices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '?').toArray();
    int leftNeeded = s.length() / 2 - (int) s.chars().filter(c -> c == '(').count();

    char[] replaced = new char[indices.length];
    for (int i = 0; i < replaced.length; ++i) {
      replaced[i] = (i < leftNeeded) ? '(' : ')';
    }
    if (leftNeeded == 0 || leftNeeded == replaced.length) {
      return true;
    }

    replaced[leftNeeded - 1] = ')';
    replaced[leftNeeded] = '(';

    char[] brackets = s.toCharArray();
    for (int i = 0; i < indices.length; ++i) {
      brackets[indices[i]] = replaced[i];
    }

    int depth = 0;
    for (char bracket : brackets) {
      depth += (bracket == '(') ? 1 : -1;
      if (depth == -1) {
        return true;
      }
    }

    return false;
  }
}