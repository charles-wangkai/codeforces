import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String countdown = sc.next();

      System.out.println(solve(countdown));
    }

    sc.close();
  }

  static String solve(String countdown) {
    StringBuilder sb = new StringBuilder();
    int digitSum = countdown.chars().map(c -> c - '0').sum();
    int carry = 0;
    int index = countdown.length() - 1;
    while (digitSum + carry != 0) {
      sb.append((digitSum + carry) % 10);
      carry = (digitSum + carry) / 10;

      if (index >= 0) {
        digitSum -= countdown.charAt(index) - '0';
        --index;
      }
    }

    return sb.reverse().toString();
  }
}