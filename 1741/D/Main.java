import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int[] p = new int[m];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    return search(p, 0, p.length - 1).operationNum();
  }

  static Outcome search(int[] p, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return new Outcome(0, p[beginIndex], p[endIndex]);
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    Outcome leftOutcome = search(p, beginIndex, middleIndex);
    Outcome rightOutcome = search(p, middleIndex + 1, endIndex);

    return (leftOutcome.operationNum() == -1
            || rightOutcome.operationNum() == -1
            || !(leftOutcome.maxValue() < rightOutcome.minValue()
                || leftOutcome.minValue() > rightOutcome.maxValue()))
        ? new Outcome(-1, -1, -1)
        : new Outcome(
            leftOutcome.operationNum()
                + rightOutcome.operationNum()
                + ((leftOutcome.minValue() > rightOutcome.maxValue()) ? 1 : 0),
            Math.min(leftOutcome.minValue(), rightOutcome.minValue()),
            Math.max(leftOutcome.maxValue(), rightOutcome.maxValue()));
  }
}

record Outcome(int operationNum, int minValue, int maxValue) {}
