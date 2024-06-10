import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] id = new int[n];
    for (int i = 0; i < id.length; ++i) {
      id[i] = sc.nextInt();
    }

    System.out.println(solve(id));

    sc.close();
  }

  static int solve(int[] id) {
    Map<Integer, Integer> sessionToCount = new HashMap<>();
    for (int session : id) {
      if (session != 0) {
        sessionToCount.put(session, sessionToCount.getOrDefault(session, 0) + 1);
      }
    }

    return sessionToCount.values().stream().anyMatch(count -> count > 2)
        ? -1
        : (int) sessionToCount.values().stream().filter(count -> count == 2).count();
  }
}