import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int s = sc.nextInt();
    char[] d = new char[n];
    int[] p = new int[n];
    int[] q = new int[n];
    for (int i = 0; i < n; ++i) {
      d[i] = sc.next().charAt(0);
      p[i] = sc.nextInt();
      q[i] = sc.nextInt();
    }

    System.out.println(solve(d, p, q, s));

    sc.close();
  }

  static String solve(char[] d, int[] p, int[] q, int s) {
    SortedMap<Integer, Integer> sellPriceToVolume = new TreeMap<>(Comparator.reverseOrder());
    SortedMap<Integer, Integer> buyPriceToVolume = new TreeMap<>(Comparator.reverseOrder());
    for (int i = 0; i < d.length; ++i) {
      if (d[i] == 'S') {
        sellPriceToVolume.put(p[i], sellPriceToVolume.getOrDefault(p[i], 0) + q[i]);
      } else {
        buyPriceToVolume.put(p[i], buyPriceToVolume.getOrDefault(p[i], 0) + q[i]);
      }
    }

    return "%s\n%s"
        .formatted(
            sellPriceToVolume.keySet().stream()
                .skip(Math.max(0, sellPriceToVolume.size() - s))
                .map(sellPrice -> "S %d %d".formatted(sellPrice, sellPriceToVolume.get(sellPrice)))
                .collect(Collectors.joining("\n")),
            buyPriceToVolume.keySet().stream()
                .limit(s)
                .map(buyPrice -> "B %d %d".formatted(buyPrice, buyPriceToVolume.get(buyPrice)))
                .collect(Collectors.joining("\n")));
  }
}