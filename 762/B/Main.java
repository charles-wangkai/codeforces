import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int m = sc.nextInt();
    int[] val = new int[m];
    String[] type = new String[m];
    for (int i = 0; i < m; ++i) {
      val[i] = sc.nextInt();
      type[i] = sc.next();
    }

    System.out.println(solve(a, b, c, val, type));

    sc.close();
  }

  static String solve(int a, int b, int c, int[] val, String[] type) {
    int[] usbCosts =
        IntStream.range(0, val.length)
            .filter(i -> type[i].equals("USB"))
            .map(i -> val[i])
            .sorted()
            .toArray();
    int[] psCosts =
        IntStream.range(0, val.length)
            .filter(i -> type[i].equals("PS/2"))
            .map(i -> val[i])
            .sorted()
            .toArray();

    int equippedCount = 0;
    long totalCost = 0;

    int usbIndex = 0;
    while (usbIndex != usbCosts.length && a != 0) {
      totalCost += usbCosts[usbIndex];

      ++equippedCount;
      ++usbIndex;
      --a;
    }

    int psIndex = 0;
    while (psIndex != psCosts.length && b != 0) {
      totalCost += psCosts[psIndex];

      ++equippedCount;
      ++psIndex;
      --b;
    }

    while ((usbIndex != usbCosts.length || psIndex != psCosts.length) && c != 0) {
      if (psIndex == psCosts.length
          || (usbIndex != usbCosts.length && usbCosts[usbIndex] <= psCosts[psIndex])) {
        totalCost += usbCosts[usbIndex];

        ++usbIndex;
      } else {
        totalCost += psCosts[psIndex];

        ++psIndex;
      }

      ++equippedCount;
      --c;
    }

    return "%d %d".formatted(equippedCount, totalCost);
  }
}