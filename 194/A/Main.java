import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static int solve(int n, int k) {
    return IntStream.rangeClosed(0, n).filter(i -> check(n, k, i)).min().getAsInt();
  }

  static boolean check(int n, int k, int twoNum) {
    int rest = k - twoNum * 2;

    return rest >= (n - twoNum) * 3 && rest <= (n - twoNum) * 5;
  }
}