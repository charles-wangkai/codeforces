import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      System.out.println(solve(l, r));
    }
  }

  static int solve(int l, int r) {
    int result = -1;
    int maxLuckiness = -1;
    for (int i = l; i <= Math.min(r, l + 100); ++i) {
      int luckiness = computeLuckiness(i);
      if (luckiness > maxLuckiness) {
        maxLuckiness = luckiness;
        result = i;
      }
    }

    return result;
  }

  static int computeLuckiness(int x) {
    String s = String.valueOf(x);

    return s.chars().max().getAsInt() - s.chars().min().getAsInt();
  }
}
