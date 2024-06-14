import java.util.ArrayList;
import java.util.Collections;
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
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, k));

    sc.close();
  }

  static long solve(int[] a, int[] b, int k) {
    Map<Integer, List<Integer>> jobToTimes = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      jobToTimes.putIfAbsent(a[i], new ArrayList<>());
      jobToTimes.get(a[i]).add(b[i]);
    }
    for (List<Integer> times : jobToTimes.values()) {
      Collections.sort(times);
    }

    int needed = 0;
    List<Integer> rests = new ArrayList<>();
    for (int i = 1; i <= k; ++i) {
      if (jobToTimes.containsKey(i)) {
        List<Integer> times = jobToTimes.get(i);
        for (int j = 0; j < times.size() - 1; ++j) {
          rests.add(times.get(j));
        }
      } else {
        ++needed;
      }
    }
    Collections.sort(rests);

    return rests.subList(0, needed).stream().mapToInt(Integer::intValue).asLongStream().sum();
  }
}