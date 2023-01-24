import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int d = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, d));

    sc.close();
  }

  static int solve(String s, int d) {
    int result = 0;
    int index = 0;
    while (index != s.length() - 1) {
      int next = Math.min(s.length() - 1, index + d);
      while (s.charAt(next) == '0') {
        --next;
      }
      if (next == index) {
        return -1;
      }

      ++result;
      index = next;
    }

    return result;
  }
}
