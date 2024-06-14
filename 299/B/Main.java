import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, k) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String s, int k) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '#') {
        ++count;
        if (count == k) {
          return false;
        }
      } else {
        count = 0;
      }
    }

    return true;
  }
}