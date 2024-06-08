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
    int lTotal = (int) s.chars().filter(c -> c == 'L').count();
    int oTotal = (int) s.chars().filter(c -> c == 'O').count();

    int lCount = 0;
    int oCount = 0;
    for (int i = 0; i < s.length() - 1; ++i) {
      if (s.charAt(i) == 'L') {
        ++lCount;
      } else {
        ++oCount;
      }

      if (lCount != lTotal - lCount && oCount != oTotal - oCount) {
        return i + 1;
      }
    }

    return -1;
  }
}