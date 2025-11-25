import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int l = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, l));

    sc.close();
  }

  static int solve(int[] a, int l) {
    return IntStream.rangeClosed(l, Arrays.stream(a).max().getAsInt())
        .map(length -> length * Arrays.stream(a).map(ai -> ai / length).sum())
        .max()
        .orElse(0);
  }
}