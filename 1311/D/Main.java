import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int a, int b, int c) {
    int minDiff = Integer.MAX_VALUE;
    int bestA = -1;
    int bestB = -1;
    int bestC = -1;
    for (int B = 1; B <= b + (c - a); ++B) {
      Element aElement = computeElementForA(a, B);
      Element cElement = computeElementForC(c, B);

      int diff = aElement.mindiff() + Math.abs(B - b) + cElement.mindiff();
      if (diff < minDiff) {
        minDiff = diff;
        bestA = aElement.value();
        bestB = B;
        bestC = cElement.value();
      }
    }

    return "%d\n%d %d %d".formatted(minDiff, bestA, bestB, bestC);
  }

  static Element computeElementForA(int a, int B) {
    int minDiff = Integer.MAX_VALUE;
    int bestValue = -1;
    for (int i = 1; i * i <= B; ++i) {
      if (B % i == 0) {
        for (int candidate : new int[] {i, B / i}) {
          int diff = Math.abs(a - candidate);
          if (diff < minDiff) {
            minDiff = diff;
            bestValue = candidate;
          }
        }
      }
    }

    return new Element(minDiff, bestValue);
  }

  static Element computeElementForC(int c, int B) {
    int minDiff = Integer.MAX_VALUE;
    int bestValue = -1;
    int floor = c / B * B;
    for (int candidate : new int[] {floor, floor + B}) {
      int diff = Math.abs(c - candidate);
      if (diff < minDiff) {
        minDiff = diff;
        bestValue = candidate;
      }
    }

    return new Element(minDiff, bestValue);
  }
}

record Element(int mindiff, int value) {}
