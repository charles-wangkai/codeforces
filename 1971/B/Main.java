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
        IntStream.range(0, s.length() - 1).filter(i -> s.charAt(i) != s.charAt(i + 1)).findAny();

    return index.isPresent()
        ? String.format(
            "YES\n%s%c%c%s",
            s.substring(0, index.getAsInt()),
            s.charAt(index.getAsInt() + 1),
            s.charAt(index.getAsInt()),
            s.substring(index.getAsInt() + 2))
        : "NO";
  }
}