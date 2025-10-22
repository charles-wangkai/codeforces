import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(k, a, b, s));

    sc.close();
  }

  static String solve(int k, int a, int b, String s) {
    int[] lengths =
        IntStream.range(0, k).map(i -> s.length() / k + ((i < s.length() % k) ? 1 : 0)).toArray();
    if (Arrays.stream(lengths).anyMatch(length -> length < a || length > b)) {
      return "No solution";
    }

    String[] lines = new String[lengths.length];
    int beginIndex = 0;
    for (int i = 0; i < lines.length; ++i) {
      lines[i] = s.substring(beginIndex, beginIndex + lengths[i]);
      beginIndex += lengths[i];
    }

    return String.join("\n", lines);
  }
}