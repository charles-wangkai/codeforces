import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[] a = new String[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.next();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(String[] a) {
    String result = "";
    for (String ai : a) {
      String s1 = ai + result;
      String s2 = result + ai;

      result = (s1.compareTo(s2) <= 0) ? s1 : s2;
    }

    return result;
  }
}