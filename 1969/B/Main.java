import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static long solve(String s) {
    long result = 0;
    int oneCount = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        if (oneCount != 0) {
          result += oneCount + 1;
        }
      } else {
        ++oneCount;
      }
    }

    return result;
  }
}