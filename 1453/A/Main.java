import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] bottoms = new int[n];
      for (int i = 0; i < bottoms.length; ++i) {
        bottoms[i] = sc.nextInt();
      }
      int[] lefts = new int[m];
      for (int i = 0; i < lefts.length; ++i) {
        lefts[i] = sc.nextInt();
      }

      System.out.println(solve(bottoms, lefts));
    }

    sc.close();
  }

  static int solve(int[] bottoms, int[] lefts) {
    Set<Integer> bottomSet = Arrays.stream(bottoms).boxed().collect(Collectors.toSet());

    return (int) Arrays.stream(lefts).filter(bottomSet::contains).count();
  }
}
