import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] u = new int[n];
    for (int i = 0; i < u.length; ++i) {
      u[i] = sc.nextInt();
    }

    System.out.println(solve(u));

    sc.close();
  }

  static int solve(int[] u) {
    Map<Integer, Integer> valueToFreq = new HashMap<>();
    Map<Integer, Integer> freqToCount = new HashMap<>();

    int result = 0;
    for (int i = 0; i < u.length; ++i) {
      if (valueToFreq.containsKey(u[i])) {
        updateMap(freqToCount, valueToFreq.get(u[i]), -1);
      }

      updateMap(valueToFreq, u[i], 1);

      updateMap(freqToCount, valueToFreq.get(u[i]), 1);

      if (check(freqToCount)) {
        result = i + 1;
      }
    }

    return result;
  }

  static boolean check(Map<Integer, Integer> freqToCount) {
    int[] sortedFreqs =
        freqToCount.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();

    return (sortedFreqs.length == 1
            && (sortedFreqs[0] == 1 || freqToCount.get(sortedFreqs[0]) == 1))
        || (sortedFreqs.length == 2
            && ((sortedFreqs[0] == 1 && freqToCount.get(sortedFreqs[0]) == 1)
                || (sortedFreqs[1] == sortedFreqs[0] + 1 && freqToCount.get(sortedFreqs[1]) == 1)));
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}