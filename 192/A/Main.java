import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int n) {
    Set<Integer> triangulars = new HashSet<>();
    for (int i = 1; ; ++i) {
      int triangular = i * (i + 1) / 2;
      if (triangular >= n) {
        break;
      }

      triangulars.add(triangular);
    }

    return triangulars.stream().anyMatch(triangular -> triangulars.contains(n - triangular));
  }
}