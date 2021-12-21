import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int w = sc.nextInt();
      int h = sc.nextInt();
      int[] bottomXs = readArray(sc);
      int[] upXs = readArray(sc);
      int[] leftYs = readArray(sc);
      int[] rightYs = readArray(sc);

      System.out.println(solve(w, h, bottomXs, upXs, leftYs, rightYs));
    }

    sc.close();
  }

  static int[] readArray(Scanner sc) {
    int size = sc.nextInt();
    int[] result = new int[size];
    for (int i = 0; i < result.length; ++i) {
      result[i] = sc.nextInt();
    }

    return result;
  }

  static long solve(int w, int h, int[] bottomXs, int[] upXs, int[] leftYs, int[] rightYs) {
    return Math.max(
        (long)
                Math.max(
                    bottomXs[bottomXs.length - 1] - bottomXs[0], upXs[upXs.length - 1] - upXs[0])
            * h,
        (long)
                Math.max(
                    leftYs[leftYs.length - 1] - leftYs[0], rightYs[rightYs.length - 1] - rightYs[0])
            * w);
  }
}
