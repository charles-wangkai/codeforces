import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int n) {
    boolean[] visited = new boolean[n];
    int index = 0;
    visited[index] = true;
    for (int i = 1; i < n; ++i) {
      index = (index + i) % visited.length;
      visited[index] = true;
    }

    return IntStream.range(0, visited.length).allMatch(i -> visited[i]);
  }
}