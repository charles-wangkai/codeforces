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

  static String solve(String s, int k) {
    StringBuilder result = new StringBuilder();
    boolean[] changed = new boolean[26];
    for (char letter : s.toCharArray()) {
      while (true) {
        while (changed[letter - 'a']) {
          --letter;
        }
        if (k == 0 || letter == 'a') {
          break;
        }

        changed[letter - 'a'] = true;
        --letter;
        --k;
      }

      result.append(letter);
    }

    return result.toString();
  }
}