import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] d = new int[m];
    for (int i = 0; i < d.length; ++i) {
      d[i] = sc.nextInt();
    }
    int[] s = new int[m];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.nextInt();
    }

    System.out.println(solve(d, s, k));

    sc.close();
  }

  static int solve(int[] d, int[] s, int k) {
    int result = Arrays.stream(d).sum();
    int sumD = 0;
    int sumS = 0;
    int maxS = 0;
    for (int i = 0; i < d.length; ++i) {
      sumD += d[i];
      sumS += s[i];
      maxS = Math.max(maxS, s[i]);

      int waitNum = (Math.max(0, sumD - sumS) + (maxS - 1)) / maxS;
      result += waitNum * k;
      sumS += waitNum * maxS;
    }

    return result;
  }
}