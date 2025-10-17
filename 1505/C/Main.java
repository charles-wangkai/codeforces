import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String s) {
    int[] values = s.chars().map(c -> c - 'A').toArray();

    return IntStream.range(2, values.length)
        .allMatch(i -> (values[i - 2] + values[i - 1]) % 26 == values[i]);
  }
}