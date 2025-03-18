import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String a = sc.next();
    String b = sc.next();

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(String a, String b) {
    return (int)
        Math.max(
            IntStream.range(0, a.length())
                .filter(i -> a.charAt(i) == '4' && b.charAt(i) == '7')
                .count(),
            IntStream.range(0, a.length())
                .filter(i -> a.charAt(i) == '7' && b.charAt(i) == '4')
                .count());
  }
}