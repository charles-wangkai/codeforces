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

  static int solve(String s) {
    if (s.contains("**") || s.contains("*<") || s.contains(">*") || s.contains("><")) {
      return -1;
    }

    int leftIndex = s.lastIndexOf('<');
    int rightIndex = s.indexOf('>');

    return (leftIndex == -1 || rightIndex == -1)
        ? s.length()
        : (Math.max(leftIndex + 1, s.length() - rightIndex) + (s.contains("*") ? 1 : 0));
  }
}