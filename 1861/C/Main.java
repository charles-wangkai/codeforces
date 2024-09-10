import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int sortedLength = 0;
    int unsortedLength = -1;
    int length = 0;
    for (char c : s.toCharArray()) {
      if (c == '1') {
        if (unsortedLength != -1) {
          return false;
        }

        sortedLength = length;
      } else if (c == '0') {
        if (length < 2 || sortedLength == length) {
          return false;
        }

        if (unsortedLength == -1) {
          unsortedLength = length;
        }
      } else if (c == '+') {
        ++length;
      } else {
        if (sortedLength == length) {
          --sortedLength;
        }
        if (unsortedLength == length) {
          unsortedLength = -1;
        }

        --length;
      }
    }

    return true;
  }
}