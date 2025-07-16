import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int a, int b) {
    int result = a + 1;
    while (!computeMask(result).equals(String.valueOf(b))) {
      ++result;
    }

    return result;
  }

  static String computeMask(int x) {
    return String.valueOf(x)
        .chars()
        .filter(c -> c == '4' || c == '7')
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
  }
}