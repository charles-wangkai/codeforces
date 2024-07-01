import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int n = sc.nextInt();
    String[] visited = new String[n];
    for (int i = 0; i < visited.length; ++i) {
      visited[i] = sc.next();
    }

    System.out.println(solve(s, visited));

    sc.close();
  }

  static String solve(String s, String[] visited) {
    return Arrays.stream(visited)
        .filter(x -> x.startsWith(s))
        .min(Comparator.naturalOrder())
        .orElse(s);
  }
}