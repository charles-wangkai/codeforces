import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, m, k));

    sc.close();
  }

  static int solve(int n, int m, int k) {
    int rest = m - n;

    int result = 1;
    int beginIndex = k - 1;
    int endIndex = k - 1;
    while (true) {
      int length = endIndex - beginIndex + 1;
      if (rest < length) {
        break;
      }

      if (beginIndex == 0 && endIndex == n - 1) {
        result += rest / length;

        break;
      }

      rest -= length;
      ++result;

      if (beginIndex != 0) {
        --beginIndex;
      }
      if (endIndex != n - 1) {
        ++endIndex;
      }
    }

    return result;
  }
}