import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static long solve(int n, int k) {
    long result = 0;
    int distance = n - 1;
    for (int i = 0; i < k && distance > 0; ++i) {
      result += 2 * distance - 1;
      distance -= 2;
    }

    return result;
  }
}