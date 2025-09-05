import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    char[][] map = new char[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if ((r + c) % 2 == 0 && k != 0) {
          map[r][c] = 'L';
          --k;
        } else {
          map[r][c] = 'S';
        }
      }
    }

    return (k == 0)
        ? "YES\n%s".formatted(Arrays.stream(map).map(String::new).collect(Collectors.joining("\n")))
        : "NO";
  }
}