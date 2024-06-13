import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    for (int tc = 0; tc < n; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : t.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    boolean[] chosen = new boolean[s.length()];
    for (char letter : letterToCount.keySet()) {
      int[] indices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == letter).toArray();
      if (indices.length < letterToCount.get(letter)) {
        return false;
      }

      for (int i = indices.length - 1; i >= indices.length - letterToCount.get(letter); --i) {
        chosen[indices[i]] = true;
      }
    }

    return IntStream.range(0, chosen.length)
        .filter(i -> chosen[i])
        .mapToObj(s::charAt)
        .map(String::valueOf)
        .collect(Collectors.joining())
        .equals(t);
  }
}