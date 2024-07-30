import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    OptionalInt index =
        IntStream.range(0, s.length() - 1).filter(i -> s.charAt(i) == s.charAt(i + 1)).findAny();
    if (index.isPresent()) {
      return insert(s, index.getAsInt() + 1, (s.charAt(index.getAsInt()) == 'a') ? 'b' : 'a');
    }

    for (char c = 'a'; ; ++c) {
      if (c != s.charAt(0) && (s.length() == 1 || c != s.charAt(1))) {
        return insert(s, 1, c);
      }
    }
  }

  static String insert(String s, int index, char c) {
    return s.substring(0, index) + c + s.substring(index);
  }
}