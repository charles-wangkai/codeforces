import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    Set<Integer> auctionIndices =
        Arrays.stream(b).map(bi -> bi - 1).boxed().collect(Collectors.toSet());

    long result =
        IntStream.range(0, a.length).filter(i -> !auctionIndices.contains(i)).map(i -> a[i]).sum();
    int[] auctionPrices =
        auctionIndices.stream()
            .map(index -> a[index])
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    for (int auctionPrice : auctionPrices) {
      result += Math.max(result, auctionPrice);
    }

    return result;
  }
}