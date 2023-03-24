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

  static int solve(String s) {
    int[] letters = s.chars().sorted().toArray();
    if (letters[0] == letters[3]) {
      return -1;
    }
    if (letters[0] == letters[2] || letters[1] == letters[3]) {
      return 6;
    }

    return 4;
  }
}
