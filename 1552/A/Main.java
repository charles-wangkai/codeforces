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

  static int solve(String s) {
    String sorted =
        s.chars().sorted().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());

    return (int)
        IntStream.range(0, s.length()).filter(i -> s.charAt(i) != sorted.charAt(i)).count();
  }
}
