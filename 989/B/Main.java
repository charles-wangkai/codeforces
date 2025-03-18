import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int p = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, p));

    sc.close();
  }

  static String solve(String s, int p) {
    char[] replaced = s.toCharArray();
    boolean diffFound = false;
    for (int i = s.length() - p - 1; i >= 0; --i) {
      if (replaced[i] == '.' || replaced[i + p] == '.') {
        if (replaced[i] == '.' && replaced[i + p] == '.') {
          replaced[i] = '0';
          replaced[i + p] = '1';
        } else if (replaced[i] == '.') {
          replaced[i] = (char) ('0' + '1' - replaced[i + p]);
        } else {
          replaced[i + p] = (char) ('0' + '1' - replaced[i]);
        }

        diffFound = true;
      } else if (replaced[i] != replaced[i + p]) {
        diffFound = true;
      }
    }

    if (!diffFound) {
      return "No";
    }

    for (int i = 0; i < replaced.length; ++i) {
      if (replaced[i] == '.') {
        replaced[i] = '0';
      }
    }

    return new String(replaced);
  }
}