import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int leftLowerCount = 0;
    int rightUpperCount = (int) s.chars().filter(Character::isUpperCase).count();
    int result = rightUpperCount;
    for (char c : s.toCharArray()) {
      if (Character.isLowerCase(c)) {
        ++leftLowerCount;
      } else {
        --rightUpperCount;
      }

      result = Math.min(result, leftLowerCount + rightUpperCount);
    }

    return result;
  }
}