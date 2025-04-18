import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    Map<String, Integer> substringToCount = new HashMap<>();
    for (int beginIndex = 0; beginIndex < s.length(); ++beginIndex) {
      for (int endIndex = beginIndex; endIndex < s.length(); ++endIndex) {
        String substring = s.substring(beginIndex, endIndex + 1);
        substringToCount.put(substring, substringToCount.getOrDefault(substring, 0) + 1);
      }
    }

    return substringToCount.keySet().stream()
        .filter(substring -> substringToCount.get(substring) != 1)
        .mapToInt(String::length)
        .max()
        .orElse(0);
  }
}