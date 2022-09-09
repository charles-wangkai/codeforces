import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] cnt = new int[n];
      for (int i = 0; i < cnt.length; ++i) {
        cnt[i] = sc.nextInt();
      }

      System.out.println(solve(cnt));
    }

    sc.close();
  }

  static int solve(int[] cnt) {
    int max = Arrays.stream(cnt).max().getAsInt();

    return IntStream.range(0, cnt.length).filter(i -> cnt[i] == max).findAny().getAsInt() + 1;
  }
}