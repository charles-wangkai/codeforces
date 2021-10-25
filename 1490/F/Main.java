import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    Map<Integer, Integer> valueToFreq = new HashMap<>();
    for (int value : a) {
      valueToFreq.put(value, valueToFreq.getOrDefault(value, 0) + 1);
    }

    SortedMap<Integer, Integer> freqToCount = new TreeMap<>();
    for (int freq : valueToFreq.values()) {
      freqToCount.put(freq, freqToCount.getOrDefault(freq, 0) + 1);
    }

    int result = a.length;
    int removeNum = a.length;
    int prevFreq = 0;
    int aboveNum = freqToCount.values().stream().mapToInt(x -> x).sum();
    for (int freq : freqToCount.keySet()) {
      removeNum -= aboveNum * (freq - prevFreq);
      result = Math.min(result, removeNum);

      aboveNum -= freqToCount.get(freq);
      removeNum += freq * freqToCount.get(freq);
      prevFreq = freq;
    }

    return result;
  }
}
