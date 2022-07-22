import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(x, a, b, c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int x, int a, int b, int c) {
    int[] pointers = {a - 1, b - 1, c - 1};
    int index = x - 1;
    boolean[] opened = new boolean[3];
    opened[index] = true;
    for (int i = 0; i < 2; ++i) {
      if (pointers[index] == -1) {
        return false;
      }

      index = pointers[index];
      opened[index] = true;
    }

    return IntStream.range(0, opened.length).allMatch(i -> opened[i]);
  }
}