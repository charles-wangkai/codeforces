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

  static long solve(String a, String b) {
    int length = b.length() - a.length() + 1;

    long result = 0;
    int zeroCount = (int) IntStream.range(0, length - 1).filter(i -> b.charAt(i) == '0').count();
    for (int i = 0; i < a.length(); ++i) {
      if (b.charAt(i + length - 1) == '0') {
        ++zeroCount;
      }

      result += (a.charAt(i) == '0') ? (length - zeroCount) : zeroCount;

      if (b.charAt(i) == '0') {
        --zeroCount;
      }
    }

    return result;
  }
}