import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] a = new String[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.next();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(String[] a) {
    return Arrays.stream(a)
        .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
        .collect(Collectors.joining());
  }
}