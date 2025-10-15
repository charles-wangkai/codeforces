import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder result = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      String a = br.readLine();
      String b = br.readLine();

      result.append(solve(a, b, k)).append("\n");
    }

    System.out.print(result);
  }

  static long solve(String a, String b, int k) {
    int letterCount = 0;
    int[] indices = new int[26];
    Arrays.fill(indices, -1);
    for (char c : a.toCharArray()) {
      if (indices[c - 'a'] == -1) {
        indices[c - 'a'] = letterCount;
        ++letterCount;
      }
    }

    long result = -1;
    for (int mask = 0; mask < 1 << letterCount; ++mask) {
      if (Integer.bitCount(mask) <= k) {
        result = Math.max(result, computePairNum(a, b, indices, mask));
      }
    }

    return result;
  }

  static long computePairNum(String a, String b, int[] indices, int mask) {
    long result = 0;
    int length = 0;
    for (int i = 0; i <= a.length(); ++i) {
      if (i != a.length()
          && (a.charAt(i) == b.charAt(i) || ((mask >> indices[a.charAt(i) - 'a']) & 1) == 1)) {
        ++length;
      } else {
        result += length * (length + 1L) / 2;

        length = 0;
      }
    }

    return result;
  }
}
