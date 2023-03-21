import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int d = sc.nextInt();
      int w = sc.nextInt();
      int[] times = new int[n];
      for (int i = 0; i < times.length; ++i) {
        times[i] = sc.nextInt();
      }

      System.out.println(solve(times, k, d, w));
    }

    sc.close();
  }

  static int solve(int[] times, int k, int d, int w) {
    int result = 0;
    int endTime = -1;
    int rest = 0;
    for (int time : times) {
      if (time <= endTime && rest != 0) {
        --rest;
      } else {
        endTime = time + w + d;
        rest = k - 1;
        ++result;
      }
    }

    return result;
  }
}
