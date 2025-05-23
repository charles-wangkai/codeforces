import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static long solve(String s) {
    int[] beginIndices =
        IntStream.range(0, s.length()).filter(i -> s.startsWith("heavy", i)).toArray();
    int[] endIndices =
        IntStream.range(0, s.length()).filter(i -> s.startsWith("metal", i)).toArray();

    long result = 0;
    int endPos = 0;
    for (int beginIndex : beginIndices) {
      while (endPos != endIndices.length && endIndices[endPos] < beginIndex) {
        ++endPos;
      }

      result += endIndices.length - endPos;
    }

    return result;
  }
}