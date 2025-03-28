import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String colors = sc.next();
    String s1 = sc.next();
    String s2 = sc.next();

    System.out.println(solve(colors, s1, s2));

    sc.close();
  }

  static String solve(String colors, String s1, String s2) {
    boolean canForward = check(colors, s1, s2);
    boolean canBackward = check(new StringBuilder(colors).reverse().toString(), s1, s2);

    if (canForward) {
      return canBackward ? "both" : "forward";
    }

    return canBackward ? "backward" : "fantasy";
  }

  static boolean check(String colors, String s1, String s2) {
    int index = colors.indexOf(s1);
    if (index == -1) {
      return false;
    }

    return colors.indexOf(s2, index + s1.length()) != -1;
  }
}