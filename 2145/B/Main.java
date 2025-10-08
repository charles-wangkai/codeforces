import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(n, s));
    }

    sc.close();
  }

  static String solve(int n, String s) {
    int topRemoved = (int) s.chars().filter(c -> c == '0').count();
    int bottomRemoved = (int) s.chars().filter(c -> c == '1').count();
    int eitherRemoved = s.length() - topRemoved - bottomRemoved;

    return IntStream.range(0, n)
        .mapToObj(
            i -> {
              if (i + 1 <= topRemoved || n - i <= bottomRemoved || s.length() == n) {
                return '-';
              }
              if (i + 1 > topRemoved + eitherRemoved && n - i > bottomRemoved + eitherRemoved) {
                return '+';
              }

              return '?';
            })
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}