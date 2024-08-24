import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    char[] letters = s.toCharArray();
    for (int i = 1; i < letters.length; ++i) {
      if (letters[i] == letters[i - 1]) {
        while (true) {
          if (letters[i] == 'z') {
            letters[i] = 'a';
          } else {
            ++letters[i];
          }

          if (letters[i] != letters[i - 1]
              && (i == letters.length - 1 || letters[i] != letters[i + 1])) {
            break;
          }
        }
      }
    }

    return new String(letters);
  }
}