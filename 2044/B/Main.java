import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(String a) {
    return new StringBuilder(
            a.chars()
                .mapToObj(c -> (char) ((c == 'w') ? c : ('p' + 'q' - c)))
                .map(String::valueOf)
                .collect(Collectors.joining()))
        .reverse()
        .toString();
  }
}