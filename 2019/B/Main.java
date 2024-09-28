import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }
      long[] k = new long[q];
      for (int i = 0; i < k.length; ++i) {
        k[i] = sc.nextLong();
      }

      System.out.println(solve(x, k));
    }

    sc.close();
  }

  static String solve(int[] x, long[] k) {
    Map<Long, Integer> segmentNumToPointNum = new HashMap<>();
    for (int i = 0; i < x.length; ++i) {
      long segmentNum = (i + 1L) * (x.length - i) - 1;
      segmentNumToPointNum.put(segmentNum, segmentNumToPointNum.getOrDefault(segmentNum, 0) + 1);
    }
    for (int i = 0; i < x.length - 1; ++i) {
      long segmentNum = (i + 1L) * (x.length - i - 1);
      segmentNumToPointNum.put(
          segmentNum, segmentNumToPointNum.getOrDefault(segmentNum, 0) + (x[i + 1] - x[i] - 1));
    }

    return Arrays.stream(k)
        .mapToInt(ki -> segmentNumToPointNum.getOrDefault(ki, 0))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}