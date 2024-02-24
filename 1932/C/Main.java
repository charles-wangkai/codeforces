import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String s = sc.next();

      System.out.println(solve(a, s, m));
    }

    sc.close();
  }

  static String solve(int[] a, String s, int m) {
    int[] result = new int[a.length];
    int leftIndex = (int) s.chars().filter(c -> c == 'L').count();
    int rightIndex = leftIndex - 1;
    int product = 1;
    for (int i = result.length - 1; i >= 0; --i) {
      if (s.charAt(i) == 'L') {
        --leftIndex;
        product = product * a[leftIndex] % m;
      } else {
        ++rightIndex;
        product = product * a[rightIndex] % m;
      }

      result[i] = product;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}