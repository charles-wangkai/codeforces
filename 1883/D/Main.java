import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();
    String[] operations = new String[q];
    for (int i = 0; i < operations.length; ++i) {
      operations[i] = sc.nextLine();
    }

    System.out.println(solve(operations));

    sc.close();
  }

  static String solve(String[] operations) {
    SortedMap<Integer, Integer> leftToCount = new TreeMap<>();
    SortedMap<Integer, Integer> rightToCount = new TreeMap<>();
    boolean[] hasIntersects = new boolean[operations.length];
    for (int i = 0; i < hasIntersects.length; ++i) {
      String[] parts = operations[i].split(" ");
      String type = parts[0];
      int left = Integer.parseInt(parts[1]);
      int right = Integer.parseInt(parts[2]);

      if (type.equals("+")) {
        updateMap(leftToCount, left, 1);
        updateMap(rightToCount, right, 1);
      } else {
        updateMap(leftToCount, left, -1);
        updateMap(rightToCount, right, -1);
      }

      hasIntersects[i] = !leftToCount.isEmpty() && leftToCount.lastKey() > rightToCount.firstKey();
    }

    return IntStream.range(0, hasIntersects.length)
        .mapToObj(i -> hasIntersects[i] ? "YES" : "NO")
        .collect(Collectors.joining("\n"));
  }

  static void updateMap(SortedMap<Integer, Integer> map, int key, int delta) {
    map.put(key, map.getOrDefault(key, 0) + delta);
    map.remove(key, 0);
  }
}