import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int total = Arrays.stream(a).sum();

    int leftSum = 0;
    for (int i = 0; i < a.length; ++i) {
      leftSum += a[i];

      int middleSum = 0;
      for (int j = i + 1; j < a.length - 1; ++j) {
        middleSum += a[j];
        int rightSum = total - leftSum - middleSum;

        int distinctCount =
            (int) IntStream.of(leftSum % 3, middleSum % 3, rightSum % 3).distinct().count();
        if (distinctCount == 1 || distinctCount == 3) {
          return "%d %d".formatted(i + 1, j + 1);
        }
      }
    }

    return "0 0";
  }
}