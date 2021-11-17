import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    String sorted =
        s.chars().sorted().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());
    int[] diffIndices =
        IntStream.range(0, s.length()).filter(i -> s.charAt(i) != sorted.charAt(i)).toArray();

    return (diffIndices.length == 0)
        ? "0"
        : String.format(
            "1\n%d %s",
            diffIndices.length,
            Arrays.stream(diffIndices)
                .mapToObj(diffIndex -> String.valueOf(diffIndex + 1))
                .collect(Collectors.joining(" ")));
  }
}
