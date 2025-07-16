import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String level = sc.next();

    System.out.println(solve(level) ? "yes" : "no");

    sc.close();
  }

  static boolean solve(String level) {
    for (int i = 0; i < level.length(); ++i) {
      for (int d = 1; i + 4 * d < level.length(); ++d) {
        int i_ = i;
        int d_ = d;
        if (IntStream.range(0, 5).allMatch(j -> level.charAt(i_ + j * d_) == '*')) {
          return true;
        }
      }
    }

    return false;
  }
}