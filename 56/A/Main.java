import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {
  static final Set<String> ALCOHOLS =
      Set.of(
          "ABSINTH",
          "BEER",
          "BRANDY",
          "CHAMPAGNE",
          "GIN",
          "RUM",
          "SAKE",
          "TEQUILA",
          "VODKA",
          "WHISKEY",
          "WINE");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] visitors = new String[n];
    for (int i = 0; i < visitors.length; ++i) {
      visitors[i] = sc.next();
    }

    System.out.println(solve(visitors));

    sc.close();
  }

  static int solve(String[] visitors) {
    return (int)
        Arrays.stream(visitors)
            .filter(
                visitor ->
                    Character.isDigit(visitor.charAt(0))
                        ? (Integer.parseInt(visitor) < 18)
                        : ALCOHOLS.contains(visitor))
            .count();
  }
}