import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    return IntStream.range(0, s.length())
        .mapToObj(
            i -> {
              char ch = s.charAt(i);

              if (i % 2 == 0) {
                return (ch == 'a') ? "b" : "a";
              } else {
                return (ch == 'z') ? "y" : "z";
              }
            })
        .collect(Collectors.joining());
  }
}
