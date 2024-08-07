import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t));
    }

    sc.close();
  }

  static String solve(String s, String t) {
    char[] letters = s.toCharArray();
    int index = 0;
    for (char c : t.toCharArray()) {
      while (index != letters.length && (letters[index] != '?' && letters[index] != c)) {
        ++index;
      }

      if (index == letters.length) {
        return "NO";
      }

      if (letters[index] == '?') {
        letters[index] = c;
      }

      ++index;
    }

    for (int i = index; i < letters.length; ++i) {
      if (letters[i] == '?') {
        letters[i] = 'a';
      }
    }

    return "YES\n%s".formatted(new String(letters));
  }
}