import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a));
    }
  }

  static int solve(int[] a) {
    return (int)
        IntStream.range(0, a.length).map(start -> computeWinner(a, start)).distinct().count();
  }

  static int computeWinner(int[] a, int start) {
    int[] rests = a.clone();
    int sum = Arrays.stream(rests).sum();
    int index = start;
    while (true) {
      if (rests[index] != 0) {
        --rests[index];
        --sum;
        if (sum == 0) {
          return index;
        }
      }

      index = (index + 1) % rests.length;
    }
  }
}