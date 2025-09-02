import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String t = sc.next();

    System.out.println(solve(t));

    sc.close();
  }

  static String solve(String t) {
    OptionalInt length =
        IntStream.range(t.length() / 2 + 1, t.length())
            .filter(i -> t.endsWith(t.substring(0, i)))
            .findAny();

    return length.isPresent() ? "YES\n%s".formatted(t.substring(0, length.getAsInt())) : "NO";
  }
}