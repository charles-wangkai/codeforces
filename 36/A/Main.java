import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    sc.nextInt();
    String s = sc.next();

    out.println(solve(s) ? "YES" : "NO");

    out.close();
    sc.close();
  }

  static boolean solve(String s) {
    int[] oneIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '1').toArray();

    return IntStream.range(0, oneIndices.length - 1)
            .map(i -> oneIndices[i + 1] - oneIndices[i])
            .distinct()
            .count()
        == 1;
  }
}