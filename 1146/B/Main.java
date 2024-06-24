import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String t = sc.next();

    System.out.println(solve(t));

    sc.close();
  }

  static String solve(String t) {
    String s = t.substring(0, t.length() - t.replace("a", "").length() / 2);

    return (s + s.replace("a", "")).equals(t) ? s : ":(";
  }
}