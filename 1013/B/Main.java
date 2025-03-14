import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, x));

    sc.close();
  }

  static int solve(int[] a, int x) {
    Set<Integer> values = Arrays.stream(a).boxed().collect(Collectors.toSet());
    if (values.size() != a.length) {
      return 0;
    }
    if (Arrays.stream(a).anyMatch(ai -> (ai & x) != ai && values.contains(ai & x))) {
      return 1;
    }
    if (Arrays.stream(a).map(ai -> ai & x).distinct().count() != a.length) {
      return 2;
    }

    return -1;
  }
}