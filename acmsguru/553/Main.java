import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] w = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      w[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(w, c, m, k));

    sc.close();
  }

  static String solve(int[] w, int[] c, int m, int k) {
    int n = w.length;

    int[] prefixWeightSums = new int[n + 1];
    for (int i = 1; i < prefixWeightSums.length; ++i) {
      prefixWeightSums[i] = prefixWeightSums[i - 1] + w[i - 1];
    }

    int[] prefixPriceSums = new int[n + 1];
    for (int i = 1; i < prefixPriceSums.length; ++i) {
      prefixPriceSums[i] = prefixPriceSums[i - 1] + c[i - 1];
    }

    int maxPriceSum = 0;
    int hangTakenNum = 0;
    int tableTakenNum = 0;
    int hangWeight = IntStream.range(n - m, n).map(i -> w[i]).sum();
    int hangPrice = 0;
    for (int i = n; i >= m; --i) {
      int beginIndex = i - m;

      if (i != n) {
        hangWeight += w[beginIndex] - w[i];
        hangPrice += c[i];
      }

      int index =
          findLessEqual(prefixWeightSums, prefixWeightSums[beginIndex] - (hangWeight + k - 1) / k);
      if (index == -1) {
        break;
      }

      int priceSum = prefixPriceSums[index] + hangPrice;
      if (priceSum > maxPriceSum) {
        maxPriceSum = priceSum;
        hangTakenNum = n - i;
        tableTakenNum = index;
      }
    }

    return String.format(
        "%d %d\n%s",
        hangTakenNum + tableTakenNum,
        maxPriceSum,
        "H".repeat(hangTakenNum) + "T".repeat(tableTakenNum));
  }

  static int findLessEqual(int[] prefixWeightSums, int target) {
    int result = -1;
    int lower = 0;
    int upper = prefixWeightSums.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (prefixWeightSums[middle] <= target) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}