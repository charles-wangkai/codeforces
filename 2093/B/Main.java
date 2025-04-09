import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String n = sc.next();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(String n) {
    int lastNonZeroIndex =
        IntStream.range(0, n.length()).filter(i -> n.charAt(i) != '0').max().getAsInt();

    return (int) IntStream.range(0, lastNonZeroIndex).filter(i -> n.charAt(i) != '0').count()
        + (n.length() - 1 - lastNonZeroIndex);
  }
}