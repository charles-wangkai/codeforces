import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int d = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] v = new int[k];
      for (int i = 0; i < v.length; ++i) {
        v[i] = sc.nextInt();
      }

      System.out.println(solve(a, v, d));
    }

    sc.close();
  }

  static int solve(int[] a, int[] v, int d) {
    int result = computeScore(a) + (d - 1) / 2;
    int maxLength = Arrays.stream(v).max().getAsInt();
    int length = 1;
    for (int day = 0; day < d - 1; ++day) {
      if (v[day % v.length] >= length) {
        for (int i = 0; i < v[day % v.length]; ++i) {
          ++a[i];
        }
        result = Math.max(result, computeScore(a) + (d - day - 2) / 2);

        if (length == maxLength) {
          break;
        }
        ++length;
      }
    }

    return result;
  }

  static int computeScore(int[] a) {
    return (int) IntStream.range(0, a.length).filter(i -> a[i] == i + 1).count();
  }
}