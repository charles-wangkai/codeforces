import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static String solve(int n, int a, int b) {
    int totalRound = Integer.toBinaryString(n).length() - 1;

    int index = totalRound - 1;
    while ((((a - 1) >> index) & 1) == (((b - 1) >> index) & 1)) {
      --index;
    }

    int round = index + 1;

    return (round == totalRound) ? "Final!" : String.valueOf(round);
  }
}