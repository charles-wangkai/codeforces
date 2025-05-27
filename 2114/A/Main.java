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
    int value = Integer.parseInt(s);
    int root = (int) Math.round(Math.sqrt(value));

    return (root * root == value) ? "%d 0".formatted(root) : "-1";
  }
}