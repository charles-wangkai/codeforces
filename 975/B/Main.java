import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] a = new int[14];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    return IntStream.range(0, a.length)
        .filter(i -> a[i] != 0)
        .mapToLong(i -> computeScore(a, i))
        .max()
        .getAsLong();
  }

  static long computeScore(int[] a, int takenIndex) {
    int[] stones = a.clone();
    stones[takenIndex] = 0;
    for (int i = 0; i < stones.length; ++i) {
      stones[i] += a[takenIndex] / a.length;
    }
    for (int i = 0; i < a[takenIndex] % a.length; ++i) {
      ++stones[(takenIndex + 1 + i) % stones.length];
    }

    return Arrays.stream(stones).filter(x -> x % 2 == 0).asLongStream().sum();
  }
}