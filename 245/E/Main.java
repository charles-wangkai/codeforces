import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int depth = 0;
    int minDepth = 0;
    int maxDepth = 0;
    for (char c : s.toCharArray()) {
      depth += (c == '+') ? 1 : -1;
      minDepth = Math.min(minDepth, depth);
      maxDepth = Math.max(maxDepth, depth);
    }

    return maxDepth - minDepth;
  }
}