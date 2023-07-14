import java.util.Arrays;
import java.util.Scanner;

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
    int[] sortedOdds = Arrays.stream(a).filter(x -> Math.floorMod(x, 2) == 1).sorted().toArray();

    int result =
        Arrays.stream(a).filter(x -> x % 2 == 0 && x >= 0).sum()
            + sortedOdds[sortedOdds.length - 1];
    for (int i = sortedOdds.length - 2; i >= 1; i -= 2) {
      if (sortedOdds[i] + sortedOdds[i - 1] >= 0) {
        result += sortedOdds[i] + sortedOdds[i - 1];
      }
    }

    return result;
  }
}
