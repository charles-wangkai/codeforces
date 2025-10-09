import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int rK = sc.nextInt();
      int cK = sc.nextInt();
      int rD = sc.nextInt();
      int cD = sc.nextInt();

      System.out.println(solve(n, rK, cK, rD, cD));
    }

    sc.close();
  }

  static int solve(int n, int rK, int cK, int rD, int cD) {
    if (rD >= rK) {
      return (cD >= cK) ? computeStepNum(rK, cK, rD, cD) : computeStepNum(rK, n - cK, rD, n - cD);
    }

    return (cD >= cK)
        ? computeStepNum(n - rK, cK, n - rD, cD)
        : computeStepNum(n - rK, n - cK, n - rD, n - cD);
  }

  static int computeStepNum(int rK, int cK, int rD, int cD) {
    if (rD == rK) {
      return cD;
    }
    if (cD == cK) {
      return rD;
    }

    if (rK == 0 || cK == 0) {
      return Math.max(rD, cD);
    }

    return Math.max(
        rK + computeStepNum(0, cK, rD - rK, Math.max(cK, cD - rK)),
        cK + computeStepNum(rK, 0, Math.max(rK, rD - cK), cD - cK));
  }
}