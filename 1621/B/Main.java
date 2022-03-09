import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      int[] c = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, c));
    }

    sc.close();
  }

  static String solve(int[] l, int[] r, int[] c) {
    int[] result = new int[l.length];
    int left = Integer.MAX_VALUE;
    int leftCost = -1;
    int right = Integer.MIN_VALUE;
    int rightCost = -1;
    Map<Segment, Integer> segmentToMinCost = new HashMap<>();
    for (int i = 0; i < result.length; ++i) {
      segmentToMinCost.put(
          new Segment(l[i], r[i]),
          Math.min(
              segmentToMinCost.getOrDefault(new Segment(l[i], r[i]), Integer.MAX_VALUE), c[i]));

      if (l[i] < left) {
        left = l[i];
        leftCost = c[i];
      } else if (l[i] == left) {
        leftCost = Math.min(leftCost, c[i]);
      }

      if (r[i] > right) {
        right = r[i];
        rightCost = c[i];
      } else if (r[i] == right) {
        rightCost = Math.min(rightCost, c[i]);
      }

      result[i] = leftCost + rightCost;
      Segment segment = new Segment(left, right);
      if (segmentToMinCost.containsKey(segment)) {
        result[i] = Math.min(result[i], segmentToMinCost.get(segment));
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class Segment {
  int left;
  int right;

  Segment(int left, int right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public boolean equals(Object obj) {
    Segment other = (Segment) obj;

    return left == other.left && right == other.right;
  }
}