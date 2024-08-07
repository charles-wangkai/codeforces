import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static int solve(int l, int r) {
    Map<Integer, Integer> operationNumToCount = new HashMap<>();
    int operationNum = 1;
    int begin = 1;
    int end = 3;
    while (true) {
      int lower = Math.max(l, begin);
      int upper = Math.min(r, end - 1);
      if (lower <= upper) {
        operationNumToCount.put(operationNum, upper - lower + 1);
      }

      if (end > r) {
        break;
      }

      ++operationNum;
      begin *= 3;
      end *= 3;
    }

    return operationNumToCount.keySet().stream().min(Comparator.naturalOrder()).get()
        + operationNumToCount.keySet().stream().mapToInt(o -> o * operationNumToCount.get(o)).sum();
  }
}