import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      long x = sc.nextLong();

      System.out.println(solve(k, x));
    }

    sc.close();
  }

  static int solve(int k, long x) {
    int result = 2 * k - 1;
    int lower = 1;
    int upper = 2 * k - 1;
    while (lower <= upper) {
      int middle = lower + (upper - lower) / 2;
      if (computeEmoteNum(k, middle) >= x) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static long computeEmoteNum(int k, int messageNum) {
    if (messageNum <= k) {
      return messageNum * (messageNum + 1L) / 2;
    }

    int rest = messageNum - k;

    return k * (k + 1L) / 2 + ((k - 1L) + (k - rest)) * rest / 2;
  }
}