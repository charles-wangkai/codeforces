import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      output(sc, "! %d".formatted(solve(sc)));
    }

    sc.close();
  }

  static int solve(Scanner sc) {
    int lower = 2;
    int upper = 999;
    while (lower != upper) {
      int length = upper - lower + 1;
      int length1 = length / 3;
      int length2 = length / 3 + ((length % 3 == 0) ? 0 : 1);

      int a = lower + length1;
      int b = a + length2 - 1;
      int response = query(sc, a, b);
      if (response == a * b) {
        lower = b + 1;
      } else if (response == a * (b + 1)) {
        lower = a + 1;
        upper = b;
      } else {
        upper = a;
      }
    }

    return lower;
  }

  static int query(Scanner sc, int a, int b) {
    output(sc, "? %d %d".formatted(a, b));

    return sc.nextInt();
  }

  static void output(Scanner sc, String s) {
    System.out.println(s);
    System.out.flush();
  }
}