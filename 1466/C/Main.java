import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String poem = sc.next();

      System.out.println(solve(poem));
    }

    sc.close();
  }

  static int solve(String poem) {
    char[] letters = poem.toCharArray();
    int result = 0;
    for (int i = 1; i < letters.length; ++i) {
      if (letters[i] == letters[i - 1] || (i != 1 && letters[i] == letters[i - 2])) {
        ++result;
        letters[i] = 0;
      }
    }

    return result;
  }
}
