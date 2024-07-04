import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] t = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      t[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(t, c));

    sc.close();
  }

  static String solve(int[] t, int[] c) {
    int maxSize = 0;
    int time = 0;
    int size = 0;
    for (int i = 0; i < t.length; ++i) {
      size = Math.max(0, size - (t[i] - time)) + c[i];
      maxSize = Math.max(maxSize, size);

      time = t[i];
    }

    return "%d %d".formatted(time + size, maxSize);
  }
}