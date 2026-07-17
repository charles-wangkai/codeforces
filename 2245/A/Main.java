import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    if (k * 2 > s.length()) {
      return -1;
    }

    return (int) IntStream.range(0, k).filter(i -> s.charAt(i) == 'L').count()
        + (int) IntStream.range(s.length() - k, s.length()).filter(i -> s.charAt(i) == 'R').count();
  }
}