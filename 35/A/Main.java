import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int SHUFFLE_NUM = 3;

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int ball = sc.nextInt();
    int[] a = new int[SHUFFLE_NUM];
    int[] b = new int[SHUFFLE_NUM];
    for (int i = 0; i < SHUFFLE_NUM; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    out.println(solve(ball, a, b));

    out.close();
    sc.close();
  }

  static int solve(int ball, int[] a, int[] b) {
    boolean[] cups = new boolean[3];
    cups[ball - 1] = true;
    for (int i = 0; i < a.length; ++i) {
      boolean temp = cups[a[i] - 1];
      cups[a[i] - 1] = cups[b[i] - 1];
      cups[b[i] - 1] = temp;
    }

    return IntStream.range(0, cups.length).filter(i -> cups[i]).findAny().getAsInt() + 1;
  }
}