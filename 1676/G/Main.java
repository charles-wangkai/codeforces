import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n - 1];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String s = sc.next();

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static int solve(int[] a, String s) {
    int n = s.length();

    int[] blackCounts = new int[n];
    int[] whiteCounts = new int[n];
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == 'B') {
        ++blackCounts[i];
      } else {
        ++whiteCounts[i];
      }
    }
    for (int i = a.length - 1; i >= 0; --i) {
      blackCounts[a[i] - 1] += blackCounts[i + 1];
      whiteCounts[a[i] - 1] += whiteCounts[i + 1];
    }

    return (int) IntStream.range(0, n).filter(i -> blackCounts[i] == whiteCounts[i]).count();
  }
}
