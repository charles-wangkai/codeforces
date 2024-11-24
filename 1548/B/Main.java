import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(long[] a) {
    long[] diffs =
        IntStream.range(0, a.length - 1).mapToLong(i -> Math.abs(a[i + 1] - a[i])).toArray();

    int result = 1;
    List<Element> elements = new ArrayList<>();
    for (int i = 0; i < diffs.length; ++i) {
      List<Element> nextElements = new ArrayList<>();
      for (Element element : elements) {
        long nextG = gcd(element.g(), diffs[i]);
        if (nextG != 1 && (nextElements.isEmpty() || nextG != nextElements.getLast().g())) {
          nextElements.add(new Element(element.index(), nextG));
        }
      }
      if (diffs[i] != 1 && (nextElements.isEmpty() || diffs[i] != nextElements.getLast().g())) {
        nextElements.add(new Element(i, diffs[i]));
      }

      if (!nextElements.isEmpty()) {
        result = Math.max(result, i - nextElements.getFirst().index() + 2);
      }

      elements = nextElements;
    }

    return result;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}

record Element(int index, long g) {}
