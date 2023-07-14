import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static int solve(int[] a, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    List<Integer> sequence = new ArrayList<>();
    for (int ai : a) {
      updateMap(valueToCount, ai, 1);
      sequence.add(ai);
    }

    for (int i = 0; i < a.length; ++i) {
      if (valueToCount.size() == 1) {
        return i;
      }

      updateMap(valueToCount, sequence.get(i + k - 1), 1);
      sequence.add(sequence.get(i + k - 1));

      updateMap(valueToCount, sequence.get(i), -1);
    }

    return -1;
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}
