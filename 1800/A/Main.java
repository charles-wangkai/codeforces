import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    return IntStream.range(0, s.length())
        .filter(
            i ->
                i == 0
                    || Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1)))
        .mapToObj(i -> (char) s.charAt(i))
        .map(String::valueOf)
        .collect(Collectors.joining())
        .equalsIgnoreCase("meow");
  }
}
