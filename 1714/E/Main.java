import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] fiveMultiples = Arrays.stream(a).filter(x -> x % 5 == 0).toArray();
    if (fiveMultiples.length != 0) {
      return fiveMultiples.length == a.length
          && Arrays.stream(fiveMultiples).map(x -> x + x % 10).distinct().count() == 1;
    }

    int max = Arrays.stream(a).max().getAsInt();
    int target = max;
    int rest = 2;
    while (target % 10 != 2 || rest != 0) {
      target += target % 10;
      if (target % 10 == 2) {
        --rest;
      }
    }

    int target_ = target;
    return Arrays.stream(a).allMatch(x -> canReach(x, target_));
  }

  static boolean canReach(int begin, int target) {
    while (begin % 10 != 2) {
      begin += begin % 10;
    }

    return begin <= target && (target - begin) % 20 == 0;
  }
}