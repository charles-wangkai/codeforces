import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int b = sc.nextInt();
    int p = sc.nextInt();

    System.out.println(solve(n, b, p));

    sc.close();
  }

  static String solve(int n, int b, int p) {
    int matchNum = 0;
    int rest = n;
    while (rest != 1) {
      int match = Integer.highestOneBit(rest) / 2;
      matchNum += match;
      rest -= match;
    }

    int bottleNum = matchNum * (2 * b + 1);
    int towelNum = n * p;

    return String.format("%d %d", bottleNum, towelNum);
  }
}