import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      for (int i = 0; i < l.length; ++i) {
        l[i] = sc.nextInt();
      }

      System.out.println(solve(l));
    }

    sc.close();
  }

  static int solve(int[] l) {
    Arrays.sort(l);

    return IntStream.rangeClosed(0, l.length)
        .filter(
            liarNum ->
                (liarNum == 0)
                    ? (l[l.length - 1] == 0)
                    : (l[l.length - liarNum] > liarNum
                        && (liarNum == l.length || l[l.length - liarNum - 1] <= liarNum)))
        .findAny()
        .orElse(-1);
  }
}
