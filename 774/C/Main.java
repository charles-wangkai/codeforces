import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    char[] result = new char[n / 2];
    Arrays.fill(result, '1');
    if (n % 2 == 1) {
      result[0] = '7';
    }

    return new String(result);
  }
}