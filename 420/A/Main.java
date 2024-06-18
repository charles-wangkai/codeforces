import java.util.Scanner;
import java.util.Set;

public class Main {
  static final Set<Character> MIRROR_LETTERS =
      Set.of('A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y');

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String name = sc.next();

    System.out.println(solve(name) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String name) {
    return name.chars().allMatch(c -> MIRROR_LETTERS.contains((char) c))
        && new StringBuilder(name).reverse().toString().equals(name);
  }
}