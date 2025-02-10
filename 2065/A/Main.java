import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String W = sc.next();

      System.out.println(solve(W));
    }

    sc.close();
  }

  static String solve(String W) {
    return W.substring(0, W.length() - 2) + "i";
  }
}