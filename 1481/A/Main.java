import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int px = sc.nextInt();
      int py = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(px, py, s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int px, int py, String s) {
    return (px == 0
            || (px < 0 && s.chars().filter(ch -> ch == 'L').count() >= -px)
            || (px > 0 && s.chars().filter(ch -> ch == 'R').count() >= px))
        && (py == 0
            || (py < 0 && s.chars().filter(ch -> ch == 'D').count() >= -py)
            || (py > 0 && s.chars().filter(ch -> ch == 'U').count() >= py));
  }
}
