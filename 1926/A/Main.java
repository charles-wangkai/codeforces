import java.util.Scanner;

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

  static char solve(String s) {
    return (s.chars().filter(c -> c == 'A').count() > s.chars().filter(c -> c == 'B').count())
        ? 'A'
        : 'B';
  }
}