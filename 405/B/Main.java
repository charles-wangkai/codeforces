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
    int result = 0;
    int lastIndex = -1;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == 'L') {
        if (lastIndex != -1 && (i - lastIndex) % 2 == 0) {
          ++result;
        }

        lastIndex = i;
      } else if (s.charAt(i) == 'R') {
        result += i - lastIndex - 1;

        lastIndex = i;
      }
    }
    if (lastIndex == -1) {
      result += s.length();
    } else if (s.charAt(lastIndex) == 'L') {
      result += s.length() - 1 - lastIndex;
    }

    return result;
  }
}