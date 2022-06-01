import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int leftIndex = (s.length() - 1) / 2;
    int rightIndex = s.length() - 1 - leftIndex;
    while (leftIndex != 0 && s.charAt(leftIndex) == s.charAt(leftIndex - 1)) {
      --leftIndex;
      ++rightIndex;
    }

    return rightIndex - leftIndex + 1;
  }
}