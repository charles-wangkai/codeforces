import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int oneCount = (int) s.chars().filter(ch -> ch == '1').count();

    char[] a = new char[s.length()];
    char[] b = new char[s.length()];

    int[] counts = new int[2];
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);

      ++counts[ch - '0'];

      if (ch == '1') {
        if (counts[1] * 2 <= oneCount) {
          a[i] = '(';
          b[i] = '(';
        } else {
          a[i] = ')';
          b[i] = ')';
        }
      } else {
        if (counts[0] % 2 == 0) {
          a[i] = '(';
          b[i] = ')';
        } else {
          a[i] = ')';
          b[i] = '(';
        }
      }
    }

    return (isBalanced(a) && isBalanced(b))
        ? String.format("YES\n%s\n%s", new String(a), new String(b))
        : "NO";
  }

  static boolean isBalanced(char[] brackets) {
    int depth = 0;
    for (char bracket : brackets) {
      if (bracket == '(') {
        ++depth;
      } else {
        --depth;

        if (depth == -1) {
          return false;
        }
      }
    }

    return depth == 0;
  }
}
