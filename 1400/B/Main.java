import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int p = sc.nextInt();
      int f = sc.nextInt();
      int cntS = sc.nextInt();
      int cntW = sc.nextInt();
      int s = sc.nextInt();
      int w = sc.nextInt();

      System.out.println(solve(p, f, cntS, cntW, s, w));
    }

    sc.close();
  }

  static int solve(int p, int f, int cntS, int cntW, int s, int w) {
    int result = 0;
    for (int ps = 0; ps * s <= p && ps <= cntS; ++ps) {
      int pw = Math.min((p - ps * s) / w, cntW);
      result = Math.max(result, ps + pw + computeFollowerCarryNum(f, cntS - ps, cntW - pw, s, w));
    }

    return result;
  }

  static int computeFollowerCarryNum(int f, int cnt1, int cnt2, int weight1, int weight2) {
    if (weight1 > weight2) {
      return computeFollowerCarryNum(f, cnt2, cnt1, weight2, weight1);
    }

    int f1 = Math.min(f / weight1, cnt1);
    int f2 = Math.min((f - f1 * weight1) / weight2, cnt2);

    return f1 + f2;
  }
}