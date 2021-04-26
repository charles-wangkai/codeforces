import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(a, b, s));
    }

    sc.close();
  }

  static String solve(int a, int b, String s) {
    a -= s.chars().filter(ch -> ch == '0').count();
    b -= s.chars().filter(ch -> ch == '1').count();

    char[] letters = s.toCharArray();
    for (int i = 0, j = letters.length - 1; i < j; ++i, --j) {
      if (letters[i] == '?') {
        if (letters[j] == '0') {
          letters[i] = '0';
          --a;
        } else if (letters[j] == '1') {
          letters[i] = '1';
          --b;
        }
      } else if (letters[j] == '?') {
        if (letters[i] == '0') {
          letters[j] = '0';
          --a;
        } else if (letters[i] == '1') {
          letters[j] = '1';
          --b;
        }
      } else if (letters[i] != letters[j]) {
        return "-1";
      }
    }

    if (letters.length % 2 != 0 && letters[letters.length / 2] == '?') {
      if (a % 2 != 0) {
        letters[letters.length / 2] = '0';
        --a;
      } else {
        letters[letters.length / 2] = '1';
        --b;
      }
    }

    for (int i = 0, j = letters.length - 1; i < j; ++i, --j) {
      if (letters[i] == '?') {
        if (a != 0) {
          letters[i] = '0';
          letters[j] = '0';
          a -= 2;
        } else {
          letters[i] = '1';
          letters[j] = '1';
          b -= 2;
        }
      }
    }

    return (a == 0 && b == 0) ? new String(letters) : "-1";
  }
}
