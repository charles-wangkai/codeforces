import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextInt();
    int k = sc.nextInt();

    System.out.println(String.format("! %d", solve(sc, 1, n, n - query(sc, 1, n), k)));
    System.out.flush();

    sc.close();
  }

  static int query(Scanner sc, int l, int r) {
    System.out.println(String.format("? %d %d", l, r));
    System.out.flush();

    return sc.nextInt();
  }

  static int solve(Scanner sc, int beginPos, int endPos, int zeroNum, int seq) {
    if (zeroNum == endPos - beginPos + 1) {
      return beginPos + seq - 1;
    }

    int middlePos = (beginPos + endPos) / 2;

    int leftZeroNum = (middlePos - beginPos + 1) - query(sc, beginPos, middlePos);

    return (seq <= leftZeroNum)
        ? solve(sc, beginPos, middlePos, leftZeroNum, seq)
        : solve(sc, middlePos + 1, endPos, zeroNum - leftZeroNum, seq - leftZeroNum);
  }
}
