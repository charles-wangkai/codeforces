import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int xCount = (int) s.chars().filter(c -> c == 'x').count();
    int yCount = s.length() - xCount;

    return ((xCount > yCount) ? "x" : "y").repeat(Math.abs(xCount - yCount));
  }
}