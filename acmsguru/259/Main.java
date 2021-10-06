// https://blog.csdn.net/qq_20118433/article/details/46439991

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }
    int[] L = new int[N];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(T, L));

    sc.close();
  }

  static int solve(int[] T, int[] L) {
    int[] sortedIndices =
        IntStream.range(0, T.length)
            .boxed()
            .sorted(Comparator.comparing((Integer i) -> L[i]).reversed())
            .mapToInt(x -> x)
            .toArray();

    int result = 0;
    int printedTime = 0;
    for (int index : sortedIndices) {
      printedTime += T[index];
      result = Math.max(result, printedTime + L[index]);
    }

    return result;
  }
}
