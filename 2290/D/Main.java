import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int t = sc.nextInt();
      for (int tc = 0; tc < t; ++tc) {
        sc.nextInt();
        String s = sc.next();

        System.out.println(solve(s));
      }
    }
  }

  static int solve(String s) {
    Set<Character> replaceNeeded = new HashSet<>();
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
      char letter1 = s.charAt(i);
      char letter2 = s.charAt(j);
      if (letter1 > letter2) {
        char temp = letter1;
        letter1 = letter2;
        letter2 = temp;
      }

      for (char letter = (char) (letter1 + 1); letter <= letter2; ++letter) {
        replaceNeeded.add(letter);
      }
    }

    return replaceNeeded.size();
  }
}