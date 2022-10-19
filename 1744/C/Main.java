import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      char c = sc.next().charAt(0);
      String s = sc.next();

      System.out.println(solve(s, c));
    }

    sc.close();
  }

  static int solve(String s, char c) {
    int result = 0;
    String sequence = s + s;
    int lastGreenIndex = -1;
    for (int i = sequence.length() - 1; i >= 0; --i) {
      if (sequence.charAt(i) == 'g') {
        lastGreenIndex = i;
      }
      if (sequence.charAt(i) == c && lastGreenIndex != -1) {
        result = Math.max(result, lastGreenIndex - i);
      }
    }

    return result;
  }
}
