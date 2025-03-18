import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(t));

    sc.close();
  }

  static long solve(int[] t) {
    Map<Integer, Integer> interestToCount = new HashMap<>();
    for (int ti : t) {
      interestToCount.put(ti, interestToCount.getOrDefault(ti, 0) + 1);
    }

    int zeroCount = interestToCount.getOrDefault(0, 0);

    return zeroCount * (zeroCount - 1L) / 2
        + interestToCount.keySet().stream()
            .filter(interest -> interest > 0)
            .mapToLong(
                interest ->
                    (long) interestToCount.get(interest)
                        * interestToCount.getOrDefault(-interest, 0))
            .sum();
  }
}