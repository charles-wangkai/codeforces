import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String ticket = sc.next();

      System.out.println(solve(ticket) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String ticket) {
    return computeSum(ticket.substring(0, 3)) == computeSum(ticket.substring(3));
  }

  static int computeSum(String s) {
    return s.chars().map(c -> c - '0').sum();
  }
}