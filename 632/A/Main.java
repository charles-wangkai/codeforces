import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int p = sc.nextInt();
    String[] buyers = new String[n];
    for (int i = 0; i < buyers.length; ++i) {
      buyers[i] = sc.next();
    }

    System.out.println(solve(buyers, p));

    sc.close();
  }

  static long solve(String[] buyers, int p) {
    long result = 0;
    long rest = 0;
    for (int i = buyers.length - 1; i >= 0; --i) {
      result += rest * p;
      rest *= 2;

      if (buyers[i].equals("halfplus")) {
        result += p / 2;
        ++rest;
      }
    }

    return result;
  }
}