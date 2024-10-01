import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      if (n == 1) {
        if (query(sc, "0")) {
          respond("0");
        } else {
          respond("1");
        }
      } else if (query(sc, "01")) {
        proceed(sc, n, "01");
      } else if (query(sc, "10")) {
        proceed(sc, n, "10");
      } else if (query(sc, "0")) {
        respond("0".repeat(n));
      } else {
        respond("1".repeat(n));
      }
    }

    sc.close();
  }

  static void proceed(Scanner sc, int n, String t) {
    while (t.length() != n) {
      if (query(sc, t + "0")) {
        t += "0";
      } else if (query(sc, t + "1")) {
        t += "1";
      } else {
        break;
      }
    }

    while (t.length() != n) {
      if (query(sc, "0" + t)) {
        t = "0" + t;
      } else {
        t = "1" + t;
      }
    }

    respond(t);
  }

  static boolean query(Scanner sc, String t) {
    System.out.println("? " + t);
    System.out.flush();

    return sc.nextInt() == 1;
  }

  static void respond(String s) {
    System.out.println("! " + s);
    System.out.flush();
  }
}