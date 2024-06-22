import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int r = Arrays.stream(a).map(Integer::lowestOneBit).max().getAsInt();

    return String.format("%d %d", r, (int) Arrays.stream(a).filter(ai -> ai % r == 0).count());
  }
}