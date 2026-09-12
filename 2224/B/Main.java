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
      int[] a = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    int n = a.length;

    if (Arrays.stream(a).allMatch(ai -> ai == 0)) {
      return n;
    }

    Set<Integer> values = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int maxValue = values.stream().mapToInt(Integer::intValue).max().getAsInt();

    long result = (long) maxValue * n;
    int rest = n - 1;
    int mex = 0;
    for (int value = 0; values.contains(value) && value < maxValue; ++value) {
      ++mex;
      if (mex == maxValue) {
        ++mex;
      }

      result += mex;
      --rest;
    }

    result += (long) rest * mex;

    return result;
  }
}