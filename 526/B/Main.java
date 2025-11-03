import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[(1 << (n + 1)) - 2];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(n, a));

    sc.close();
  }

  static int solve(int n, int[] a) {
    return search(n, a, 0, 0).added();
  }

  static Outcome search(int n, int[] a, int depth, int node) {
    if (depth == n) {
      return new Outcome(0, 0);
    }

    Outcome leftOutcome = search(n, a, depth + 1, node * 2 + 1);
    Outcome rightOutcome = search(n, a, depth + 1, node * 2 + 2);

    int leftMaxPathSum = leftOutcome.maxPathSum() + a[node * 2];
    int rightMaxPathSum = rightOutcome.maxPathSum() + a[node * 2 + 1];

    int maxPathSum = Math.max(leftMaxPathSum, rightMaxPathSum);
    int added =
        leftOutcome.added()
            + rightOutcome.added()
            + (maxPathSum - leftMaxPathSum)
            + (maxPathSum - rightMaxPathSum);

    return new Outcome(maxPathSum, added);
  }
}

record Outcome(int maxPathSum, int added) {}
