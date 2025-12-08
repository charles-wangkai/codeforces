import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    int result = 0;
    int lastOneIndex = -1;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        lastOneIndex = i;
      } else if (lastOneIndex == -1 || i - lastOneIndex > k) {
        ++result;
      }
    }

    return result;
  }
}