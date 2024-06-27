import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int l, int r) {
    int maxSize = 1;
    while (l * (1 << maxSize) <= r) {
      ++maxSize;
    }

    int setNum = r / (1 << (maxSize - 1)) - l + 1;
    if (maxSize != 1 && l * (1 << (maxSize - 2)) * 3 <= r) {
      setNum += (r / ((1 << (maxSize - 2)) * 3) - l + 1) * (maxSize - 1);
    }

    return String.format("%d %d", maxSize, setNum);
  }
}