import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int result = 0;
    Set<Long> sums = new HashSet<>();
    long sum = 0;
    for (int ai : a) {
      sum += ai;

      if (sum == 0 || sums.contains(sum)) {
        ++result;

        sums.clear();
        sums.add((long) ai);
        sum = ai;
      } else {
        sums.add(sum);
      }
    }

    return result;
  }
}
