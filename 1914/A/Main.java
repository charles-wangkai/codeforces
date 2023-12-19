import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 26;

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

  static int solve(String s) {
    int[] counts = new int[LIMIT];
    for (char c : s.toCharArray()) {
      ++counts[c - 'A'];
    }

    return (int) IntStream.range(0, counts.length).filter(i -> counts[i] >= i + 1).count();
  }
}