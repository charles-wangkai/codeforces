import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int P = sc.nextInt();

      System.out.println(solve(P));
    }

    sc.close();
  }

  static String solve(int P) {
    return String.format("2 %d", P - 1);
  }
}
