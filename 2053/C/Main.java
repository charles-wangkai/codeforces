import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static long solve(int n, int k) {
    Map<Integer, Outcome> cache = new HashMap<>();

    return search(cache, k, n).lucky();
  }

  static Outcome search(Map<Integer, Outcome> cache, int k, int n) {
    if (n < k) {
      return new Outcome(0, 0);
    }

    if (!cache.containsKey(n)) {
      Outcome subOutcome = search(cache, k, n / 2);

      cache.put(
          n,
          (n % 2 == 0)
              ? new Outcome(
                  subOutcome.lucky() + (subOutcome.lucky() + n / 2L * subOutcome.size()),
                  subOutcome.size() * 2)
              : new Outcome(
                  subOutcome.lucky()
                      + (subOutcome.lucky() + (n / 2L + 1) * subOutcome.size())
                      + (n / 2 + 1),
                  subOutcome.size() * 2 + 1));
    }

    return cache.get(n);
  }
}

record Outcome(long lucky, int size) {}
