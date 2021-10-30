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

  static String solve(String s) {
    for (char ch = 'a'; ; ++ch) {
      int index = s.indexOf(ch);
      if (index >= 0) {
        return String.format("%c %s%s", ch, s.substring(0, index), s.substring(index + 1));
      }
    }
  }
}
