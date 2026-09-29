import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static long solve(int n, int m) {
    int zeroNum = n - m;
    int bucketNum = m + 1;
    int avg = zeroNum / bucketNum;
    int excess = zeroNum % bucketNum;

    return computePairNum(n)
        - (bucketNum - excess) * computePairNum(avg)
        - excess * computePairNum(avg + 1);
  }

  static long computePairNum(int length) {
    return length * (length + 1L) / 2;
  }
}