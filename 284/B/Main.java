import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int iCount = (int) s.chars().filter(c -> c == 'I').count();
    if (iCount > 1) {
      return 0;
    }
    if (iCount == 1) {
      return 1;
    }

    return (int) s.chars().filter(c -> c == 'A').count();
  }
}