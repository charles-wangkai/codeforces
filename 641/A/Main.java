import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String directions = sc.next();
    int[] d = new int[n];
    for (int i = 0; i < d.length; ++i) {
      d[i] = sc.nextInt();
    }

    System.out.println(solve(directions, d));

    sc.close();
  }

  static String solve(String directions, int[] d) {
    boolean[] visited = new boolean[directions.length()];
    int index = 0;
    while (true) {
      if (!(index >= 0 && index < visited.length)) {
        return "FINITE";
      }
      if (visited[index]) {
        return "INFINITE";
      }

      visited[index] = true;
      index += d[index] * ((directions.charAt(index) == '<') ? -1 : 1);
    }
  }
}