import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();
    for (int tc = 0; tc < N; ++tc) {
      String s = sc.nextLine();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int atIndex = s.indexOf('@');

    return atIndex != -1 && isPrefix(s.substring(0, atIndex)) && isSuffix(s.substring(atIndex + 1));
  }

  static boolean isSuffix(String s) {
    int dotIndex = s.lastIndexOf('.');

    return dotIndex != -1
        && isPrefix(s.substring(0, dotIndex))
        && isDomain(s.substring(dotIndex + 1));
  }

  static boolean isDomain(String s) {
    return s.length() >= 2 && s.length() <= 3 && s.chars().allMatch(c -> isLetter((char) c));
  }

  static boolean isPrefix(String s) {
    return !s.isEmpty() && Arrays.stream(s.split("\\.", -1)).allMatch(Main::isWord);
  }

  static boolean isWord(String s) {
    return !s.isEmpty() && s.chars().allMatch(c -> isSymbol((char) c));
  }

  static boolean isSymbol(char c) {
    return isLetter(c) || (c >= '0' && c <= '9') || c == '_' || c == '-';
  }

  static boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
}
