import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      sc.nextInt();
      String t = sc.next();

      System.out.println(solve(t));
    }

    sc.close();
  }

  static String solve(String t) {
    StringBuilder reversed = new StringBuilder();
    int index = t.length() - 1;
    while (index != -1) {
      if (t.charAt(index) == '0') {
        reversed.append(
            (char) (10 * (t.charAt(index - 2) - '0') + (t.charAt(index - 1) - '0') - 1 + 'a'));
        index -= 3;
      } else {
        reversed.append((char) ((t.charAt(index) - '0') - 1 + 'a'));
        --index;
      }
    }

    return reversed.reverse().toString();
  }
}