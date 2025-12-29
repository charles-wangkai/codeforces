import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String r = sc.next();

      System.out.println(solve(r));
    }

    sc.close();
  }

  static int solve(String r) {
    char[] letters = r.toCharArray();

    int result = 0;
    for (int index : new int[] {0, letters.length - 1}) {
      if (letters[index] == 'u') {
        letters[index] = 's';
        ++result;
      }
    }

    int count = 0;
    for (int i = 0; i <= letters.length; ++i) {
      if (i != letters.length && letters[i] == 'u') {
        ++count;
      } else {
        result += count / 2;
        count = 0;
      }
    }

    return result;
  }
}