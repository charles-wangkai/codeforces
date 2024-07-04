import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    out.println(solve(a, k));

    out.close();
    sc.close();
  }

  static int solve(int[] a, int k) {
    int index = k - 1;
    while (a[index] == 0) {
      index = (index + 1) % a.length;
    }

    return index + 1;
  }
}