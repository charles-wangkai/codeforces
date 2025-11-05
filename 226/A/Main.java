// https://en.wikipedia.org/wiki/Tower_of_Hanoi#Linear_Hanoi

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static int solve(int n, int m) {
    return addMod(powMod(3, n, m), -1, m);
  }

  static int addMod(int x, int y, int m) {
    return Math.floorMod(x + y, m);
  }

  static int multiplyMod(int x, int y, int m) {
    return Math.floorMod((long) x * y, m);
  }

  static int powMod(int base, int exponent, int m) {
    return (exponent == 0)
        ? 1
        : multiplyMod(
            (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base, m), exponent / 2, m), m);
  }
}