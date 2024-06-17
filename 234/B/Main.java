import java.io.File;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(int[] a, int k) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> a[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    return String.format(
        "%d\n%s",
        a[sortedIndices[k - 1]],
        IntStream.range(0, k)
            .map(i -> sortedIndices[i] + 1)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" ")));
  }
}