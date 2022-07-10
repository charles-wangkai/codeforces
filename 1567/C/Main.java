import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    String s = String.valueOf(n);

    return (toInt(
                    IntStream.range(0, s.length())
                        .filter(i -> i % 2 == 0)
                        .mapToObj(i -> String.valueOf(s.charAt(i)))
                        .collect(Collectors.joining()))
                + 1)
            * (toInt(
                    IntStream.range(0, s.length())
                        .filter(i -> i % 2 != 0)
                        .mapToObj(i -> String.valueOf(s.charAt(i)))
                        .collect(Collectors.joining()))
                + 1)
        - 2;
  }

  static int toInt(String x) {
    return (x.isEmpty()) ? 0 : Integer.parseInt(x);
  }
}