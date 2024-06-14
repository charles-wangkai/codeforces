import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    Arrays.sort(a);

    int[] result = new int[a.length];
    int index = 0;
    for (int i = 0; i < result.length; i += 2) {
      result[i] = a[index];
      ++index;
    }
    for (int i = 1; i < result.length; i += 2) {
      result[i] = a[index];
      ++index;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}