import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String b = sc.next();

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(String b) {
    StringBuilder result = new StringBuilder();
    int prevSum = -1;
    for (char ch : b.toCharArray()) {
      int digitB = ch - '0';
      for (int digitA = 1; ; --digitA) {
        if (digitA + digitB != prevSum) {
          result.append(digitA);
          prevSum = digitA + digitB;

          break;
        }
      }
    }

    return result.toString();
  }
}
