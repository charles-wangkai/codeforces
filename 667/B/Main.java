import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] l = new int[n];
    for (int i = 0; i < l.length; ++i) {
      l[i] = sc.nextInt();
    }

    System.out.println(solve(l));

    sc.close();
  }

  static int solve(int[] l) {
    Arrays.sort(l);

    return l[l.length - 1] - IntStream.range(0, l.length - 1).map(i -> l[i]).sum() + 1;
  }
}