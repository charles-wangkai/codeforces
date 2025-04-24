import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    sc.nextInt();
    String s = sc.next();

    out.println(solve(s));

    out.close();
    sc.close();
  }

  static String solve(String s) {
    return IntStream.range(0, s.length() / 2)
        .mapToObj(
            i ->
                (s.charAt(i) == 'R' && s.charAt(i + s.length() / 2) == 'L')
                    ? "%d %d".formatted(i + 1 + s.length() / 2, i + 1)
                    : "%d %d".formatted(i + 1, i + 1 + s.length() / 2))
        .collect(Collectors.joining("\n"));
  }
}