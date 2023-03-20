import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    Map<Character, List<Integer>> letterToIndices = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      char letter = s.charAt(i);
      letterToIndices.putIfAbsent(letter, new ArrayList<>());
      letterToIndices.get(letter).add(i);
    }

    return letterToIndices.values().stream()
        .allMatch(indices -> indices.stream().mapToInt(x -> x % 2).distinct().count() == 1);
  }
}
