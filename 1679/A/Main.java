import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(long n) {
    if (n == 2 || n % 2 != 0) {
      return "-1";
    }

    long halfN = n / 2;

    long twoMaxNum = halfN / 2;
    while ((halfN - twoMaxNum * 2) % 3 != 0) {
      --twoMaxNum;
    }

    long threeMaxNum = halfN / 3;
    while ((halfN - threeMaxNum * 3) % 2 != 0) {
      --threeMaxNum;
    }

    return String.format(
        "%d %d",
        threeMaxNum + (halfN - threeMaxNum * 3) / 2, twoMaxNum + (halfN - twoMaxNum * 2) / 3);
  }
}