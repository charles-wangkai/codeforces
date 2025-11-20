import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int n = sc.nextInt();

      out.println(solve(n));
    }

    out.close();
    sc.close();
  }

  static int solve(int n) {
    return (n % 2 == 1) ? 0 : 1;
  }
}