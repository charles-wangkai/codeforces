import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
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

  static long solve(String s) {
    Deque<Integer> zeroIndices = new ArrayDeque<>();
    Deque<Integer> oneIndices = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      ((s.charAt(i) == '0') ? zeroIndices : oneIndices).offerLast(i);
    }

    long result = IntStream.range(0, s.length()).map(i -> i + 1).asLongStream().sum();
    while (!oneIndices.isEmpty()) {
      int oneIndex = oneIndices.pollLast();
      while (!zeroIndices.isEmpty() && zeroIndices.peekLast() > oneIndex) {
        zeroIndices.pollLast();
      }

      if (!zeroIndices.isEmpty()) {
        zeroIndices.pollLast();
        result -= oneIndex + 1;
      } else if (oneIndices.isEmpty()) {
        break;
      } else {
        oneIndices.pollFirst();
        result -= oneIndex + 1;
      }
    }

    return result;
  }
}