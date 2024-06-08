import java.util.Scanner;

public class Main {
  static final String TARGET = "heidi";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String s) {
    int fromIndex = 0;
    for (char c : TARGET.toCharArray()) {
      int index = s.indexOf(c, fromIndex);
      if (index == -1) {
        return false;
      }

      fromIndex = index + 1;
    }

    return true;
  }
}