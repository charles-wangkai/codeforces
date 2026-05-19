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

  static int solve(String s) {
    String removed = s.replace("4", "");

    int rightEvenCount = (int) removed.chars().filter(c -> (c - '0') % 2 == 0).count();
    int leftOddCount = 0;
    int result = s.length() - removed.length() + (leftOddCount + rightEvenCount);
    for (char c : removed.toCharArray()) {
      if ((c - '0') % 2 == 0) {
        --rightEvenCount;
      } else {
        ++leftOddCount;
      }

      result = Math.min(result, s.length() - removed.length() + (leftOddCount + rightEvenCount));
    }

    return result;
  }
}