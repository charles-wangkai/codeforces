import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String n = sc.next();
    String m = sc.next();

    System.out.println(solve(n, m));

    sc.close();
  }

  static int solve(String n, String m) {
    Map<Character, Integer> paperColorToCount = buildColorToCount(n);
    Map<Character, Integer> garlandColorToCount = buildColorToCount(m);

    int result = 0;
    for (char garlandColor : garlandColorToCount.keySet()) {
      if (!paperColorToCount.containsKey(garlandColor)) {
        return -1;
      }

      result +=
          Math.min(paperColorToCount.get(garlandColor), garlandColorToCount.get(garlandColor));
    }

    return result;
  }

  static Map<Character, Integer> buildColorToCount(String s) {
    Map<Character, Integer> colorToCount = new HashMap<>();
    for (char color : s.toCharArray()) {
      colorToCount.put(color, colorToCount.getOrDefault(color, 0) + 1);
    }

    return colorToCount;
  }
}