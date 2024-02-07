import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(n, k, s));
    }

    sc.close();
  }

  static String solve(int n, int k, String s) {
    int count = 0;
    StringBuilder prefix = new StringBuilder();
    Set<Character> seen = new HashSet<>();
    for (char c : s.toCharArray()) {
      seen.add(c);
      if (seen.size() == k) {
        prefix.append(c);

        ++count;
        if (count == n) {
          return "YES";
        }

        seen.clear();
      }
    }

    return String.format(
        "NO\n%s%c%s",
        prefix.toString(),
        IntStream.rangeClosed('a', 'z')
            .mapToObj(c -> (char) c)
            .filter(c -> !seen.contains(c))
            .findAny()
            .get(),
        "a".repeat(n - prefix.length() - 1));
  }
}