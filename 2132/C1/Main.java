import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int LIMIT = 1_000_000_000;

  static List<Element> elements;

  public static void main(String[] args) {
    preprocess();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
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

  static long solve(int n) {
    long result = 0;
    for (Element element : elements) {
      while (n >= element.watermelon()) {
        result += element.coin();
        n -= element.watermelon();
      }
    }

    return result;
  }
}

record Element(int watermelon, long coin) {}
