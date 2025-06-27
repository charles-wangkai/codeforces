import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, k));

    sc.close();
  }

  static String solve(String s, int k) {
    StringBuilder result = new StringBuilder();
    for (char letter : s.toCharArray()) {
      int k_ = k;
      char chosen =
          (char)
              IntStream.rangeClosed('a', 'z')
                  .boxed()
                  .filter(c -> computeDistance((char) c.intValue(), letter) <= k_)
                  .max(
                      Comparator.<Integer, Integer>comparing(
                          c -> computeDistance((char) c.intValue(), letter)))
                  .get()
                  .intValue();
      result.append(chosen);
      k -= computeDistance(chosen, letter);
    }

    return (k == 0) ? result.toString() : "-1";
  }

  static int computeDistance(char c1, char c2) {
    return Math.abs(c1 - c2);
  }
}