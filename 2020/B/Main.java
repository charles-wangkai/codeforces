import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long k = sc.nextLong();

      System.out.println(solve(k));
    }

    sc.close();
  }

  static long solve(long k) {
    long result = -1;
    long lower = 1;
    long upper = k * 2;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (computeOnNum(middle) >= k) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static long computeOnNum(long n) {
    int root = (int) Math.round(Math.sqrt(n));
    if ((long) root * root > n) {
      --root;
    }

    return n - root;
  }
}