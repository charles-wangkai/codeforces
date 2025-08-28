import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 1_000_000_000;

  static List<Element> elements;

  public static void main(String[] args) {
    preprocess();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static void preprocess() {
    elements = new ArrayList<>();

    int x = 0;
    long watermelon = 1;
    while (watermelon <= LIMIT) {
      elements.add(new Element((int) watermelon, watermelon * 3 + x * (watermelon / 3)));

      ++x;
      watermelon *= 3;
    }
    Collections.sort(elements, Comparator.comparing(Element::watermelon).reversed());
  }

  static long solve(int n, int k) {
    long[] counts = new long[elements.size()];
    for (int i = 0; i < counts.length; ++i) {
      while (n >= elements.get(i).watermelon()) {
        ++counts[i];
        n -= elements.get(i).watermelon();
      }
    }

    int dealNum = (int) Arrays.stream(counts).sum();
    if (dealNum > k) {
      return -1;
    }

    for (int i = 0; i < counts.length - 1; ++i) {
      int down = (int) Math.min((k - dealNum) / 2, counts[i]);

      counts[i] -= down;
      counts[i + 1] += 3 * down;
      dealNum += 2 * down;
    }

    return IntStream.range(0, counts.length)
        .mapToLong(i -> counts[i] * elements.get(i).coin())
        .sum();
  }
}

record Element(int watermelon, long coin) {}
