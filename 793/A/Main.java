import java.util.Arrays;
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

    System.out.println(solve(a, k));

    sc.close();
  }

  static long solve(int[] a, int k) {
    int min = Arrays.stream(a).min().getAsInt();

    return Arrays.stream(a).anyMatch(ai -> (ai - min) % k != 0)
        ? -1
        : Arrays.stream(a).map(ai -> (ai - min) / k).asLongStream().sum();
  }
}