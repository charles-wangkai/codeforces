import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int[] rests = Arrays.stream(a).filter(x -> x % min != 0).sorted().toArray();

    return rests.length == 0 || Arrays.stream(rests).allMatch(x -> x % rests[0] == 0);
  }
}