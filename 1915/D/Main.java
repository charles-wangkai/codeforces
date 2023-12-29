import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String word = sc.next();

      System.out.println(solve(word));
    }

    sc.close();
  }

  static String solve(String word) {
    StringBuilder result = new StringBuilder();
    int index = 0;
    while (index != word.length()) {
      if (!result.isEmpty()) {
        result.append('.');
      }
      result.append(word.substring(index, index + 2));
      index += 2;

      if (index != word.length()
          && (index + 1 == word.length() || "bcd".indexOf(word.charAt(index + 1)) != -1)) {
        result.append(word.charAt(index));
        ++index;
      }
    }

    return result.toString();
  }
}