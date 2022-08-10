import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int nr = sc.nextInt();
      int ng = sc.nextInt();
      int nb = sc.nextInt();
      int[] r = new int[nr];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }
      int[] g = new int[ng];
      for (int i = 0; i < g.length; ++i) {
        g[i] = sc.nextInt();
      }
      int[] b = new int[nb];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(r, g, b));
    }

    sc.close();
  }

  static long solve(int[] r, int[] g, int[] b) {
    NavigableSet<Integer> redWeights = buildWeightSet(r);
    NavigableSet<Integer> greenWeights = buildWeightSet(g);
    NavigableSet<Integer> blueWeights = buildWeightSet(b);

    return LongStream.of(
            computeBalance(redWeights, greenWeights, blueWeights),
            computeBalance(redWeights, blueWeights, greenWeights),
            computeBalance(greenWeights, blueWeights, redWeights),
            computeBalance(greenWeights, redWeights, blueWeights),
            computeBalance(blueWeights, redWeights, greenWeights),
            computeBalance(blueWeights, greenWeights, redWeights))
        .min()
        .getAsLong();
  }

  static NavigableSet<Integer> buildWeightSet(int[] weights) {
    NavigableSet<Integer> result = new TreeSet<>();
    for (int weight : weights) {
      result.add(weight);
    }

    return result;
  }

  static long computeBalance(
      NavigableSet<Integer> middleWeights,
      NavigableSet<Integer> leftWeights,
      NavigableSet<Integer> rightWeights) {
    return middleWeights.stream()
        .mapToLong(
            middleWeight -> {
              Integer leftWeight = leftWeights.floor(middleWeight);
              if (leftWeight == null) {
                return Long.MAX_VALUE;
              }

              Integer rightWeight = rightWeights.ceiling(middleWeight);
              if (rightWeight == null) {
                return Long.MAX_VALUE;
              }

              return (long) (middleWeight - leftWeight) * (middleWeight - leftWeight)
                  + (long) (middleWeight - rightWeight) * (middleWeight - rightWeight)
                  + (long) (leftWeight - rightWeight) * (leftWeight - rightWeight);
            })
        .min()
        .getAsLong();
  }
}