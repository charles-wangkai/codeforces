import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextLong();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static int solve(long n, int k) {
    int result = -1;
    int lower = 0;
    int upper = k - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(n, k, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(long n, int k, int splitterNum) {
    return ((k - 1L) + (k - splitterNum)) * splitterNum / 2 >= n - 1;
  }
}