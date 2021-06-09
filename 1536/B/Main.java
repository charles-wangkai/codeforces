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
    for (int length = 1; ; ++length) {
      String result = search(s, length, new StringBuilder());
      if (result != null) {
        return result;
      }
    }
  }

  static String search(String s, int length, StringBuilder current) {
    if (current.length() == length) {
      return s.contains(current.toString()) ? null : current.toString();
    }

    for (char ch = 'a'; ch <= 'z'; ++ch) {
      current.append(ch);

      String result = search(s, length, current);
      if (result != null) {
        return result;
      }

      current.deleteCharAt(current.length() - 1);
    }

    return null;
  }
}
