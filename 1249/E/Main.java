import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int c = sc.nextInt();
    int[] a = new int[n - 1];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n - 1];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c));

    sc.close();
  }

  static String solve(int[] a, int[] b, int c) {
    int n = a.length + 1;

    int[] result = new int[n];
    int inTime = Integer.MAX_VALUE;
    int outTime = 0;
    for (int i = 0; i < result.length; ++i) {
      result[i] =
          Math.min(outTime, (inTime == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (inTime + c));

      if (i != result.length - 1) {
        int nextInTime = Integer.MAX_VALUE;
        int nextOutTime = Integer.MAX_VALUE;

        if (inTime != Integer.MAX_VALUE) {
          nextInTime = Math.min(nextInTime, inTime + b[i]);
          nextOutTime = Math.min(nextOutTime, inTime + c + a[i]);
        }

        nextInTime = Math.min(nextInTime, outTime + b[i]);
        nextOutTime = Math.min(nextOutTime, outTime + a[i]);

        inTime = nextInTime;
        outTime = nextOutTime;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}