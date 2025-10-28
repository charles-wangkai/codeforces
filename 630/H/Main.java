import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static long solve(int n) {
    long result = 1;
    for (int i = 0; i < 5; ++i) {
      result = result * (n - i) / (i + 1);
    }
    for (int i = 0; i < 5; ++i) {
      result *= n - i;
    }

    return result;
  }
}