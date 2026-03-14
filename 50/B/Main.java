import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    Map<Character, Integer> symbolToCount = new HashMap<>();
    for (char symbol : S.toCharArray()) {
      symbolToCount.put(symbol, symbolToCount.getOrDefault(symbol, 0) + 1);
    }

    return symbolToCount.values().stream().mapToLong(count -> (long) count * count).sum();
  }
}