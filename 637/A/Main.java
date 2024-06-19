import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    Map<Integer, Integer> photoToCount = new HashMap<>();
    Map<Integer, Integer> photoToLastIndex = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      photoToCount.put(a[i], photoToCount.getOrDefault(a[i], 0) + 1);
      photoToLastIndex.put(a[i], i);
    }

    int maxCount = photoToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return photoToCount.keySet().stream()
        .filter(photo -> photoToCount.get(photo) == maxCount)
        .min(Comparator.comparing(photoToLastIndex::get))
        .get();
  }
}