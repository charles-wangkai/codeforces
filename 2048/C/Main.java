import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int beginIndex;
    int endIndex;
    int zeroIndex = s.indexOf('0');
    if (zeroIndex == -1) {
      beginIndex = 0;
      endIndex = 0;
    } else {
      int oneIndex = s.indexOf('1', zeroIndex);
      int oneLength = Math.min(zeroIndex, ((oneIndex == -1) ? s.length() : oneIndex) - zeroIndex);

      beginIndex = zeroIndex - oneLength;
      endIndex = beginIndex + (s.length() - zeroIndex) - 1;
    }

    return "1 %d %d %d".formatted(s.length(), beginIndex + 1, endIndex + 1);
  }
}