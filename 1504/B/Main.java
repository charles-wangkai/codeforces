import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a, String b) {
    int[] counts = new int[2];
    counts[0] = (int) a.chars().filter(ch -> ch == '0').count();
    counts[1] = a.length() - counts[0];

    boolean inverted = false;
    for (int i = a.length() - 1; i >= 0; --i) {
      char chA = a.charAt(i);
      char chB = b.charAt(i);

      if (inverted == (chA == chB)) {
        if (counts[0] != counts[1]) {
          return false;
        }

        inverted = !inverted;
      }

      --counts[chA - '0'];
    }

    return true;
  }
}
