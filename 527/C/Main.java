import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int w = sc.nextInt();
    int h = sc.nextInt();
    int n = sc.nextInt();
    sc.nextLine();
    String[] cuts = new String[n];
    for (int i = 0; i < cuts.length; ++i) {
      cuts[i] = sc.nextLine();
    }

    System.out.println(solve(w, h, cuts));

    sc.close();
  }

  static String solve(int w, int h, String[] cuts) {
    NavigableSet<Integer> xs = new TreeSet<>();
    xs.add(0);
    xs.add(w);

    SortedMap<Integer, Integer> widthToCount = new TreeMap<>();
    updateMap(widthToCount, w, 1);

    NavigableSet<Integer> ys = new TreeSet<>();
    ys.add(0);
    ys.add(h);

    SortedMap<Integer, Integer> heightToCount = new TreeMap<>();
    updateMap(heightToCount, h, 1);

    long[] result = new long[cuts.length];
    for (int i = 0; i < result.length; ++i) {
      String[] fields = cuts[i].split(" ");
      if (fields[0].equals("H")) {
        int y = Integer.parseInt(fields[1]);

        int yLower = ys.lower(y);
        int yHigher = ys.higher(y);
        updateMap(heightToCount, yHigher - yLower, -1);
        updateMap(heightToCount, y - yLower, 1);
        updateMap(heightToCount, yHigher - y, 1);

        ys.add(y);
      } else {
        int x = Integer.parseInt(fields[1]);

        int xLower = xs.lower(x);
        int xHigher = xs.higher(x);
        updateMap(widthToCount, xHigher - xLower, -1);
        updateMap(widthToCount, x - xLower, 1);
        updateMap(widthToCount, xHigher - x, 1);

        xs.add(x);
      }

      result[i] = (long) widthToCount.lastKey() * heightToCount.lastKey();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateMap(SortedMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}