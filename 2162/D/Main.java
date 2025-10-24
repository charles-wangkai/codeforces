import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      int l = 1;
      int lower = 1;
      int upper = n;
      while (lower <= upper) {
        int middle = (lower + upper) / 2;
        if (query(sc, 1, 1, middle) == query(sc, 2, 1, middle)) {
          l = middle + 1;
          lower = middle + 1;
        } else {
          upper = middle - 1;
        }
      }

      int length = query(sc, 2, 1, n) - query(sc, 1, 1, n);
      int r = l + length - 1;

      output("! %d %d".formatted(l, r));
    }

    sc.close();
  }

  static int query(Scanner sc, int type, int l, int r) {
    output("%d %d %d".formatted(type, l, r));

    return sc.nextInt();
  }

  static void output(String s) {
    System.out.println(s);
    System.out.flush();
  }
}