import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
    int[] S = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < S.length; ++i) {
      S[i] = Integer.parseInt(st.nextToken());
    }
    int[] P = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < P.length; ++i) {
      P[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(S, P, D));
  }

  static int solve(int[] S, int[] P, int D) {
    int threshold = S[D - 1] + P[0];

    NavigableMap<Integer, Integer> awardToCount = new TreeMap<>();
    for (int i = 1; i < P.length; ++i) {
      updateMap(awardToCount, P[i], 1);
    }

    int result = 1;
    for (int i = 0; i < S.length; ++i) {
      if (i != D - 1) {
        Integer award = awardToCount.floorKey(threshold - S[i]);
        if (award == null) {
          updateMap(awardToCount, awardToCount.lastKey(), -1);
          ++result;
        } else {
          updateMap(awardToCount, award, -1);
        }
      }
    }

    return result;
  }

  static void updateMap(NavigableMap<Integer, Integer> awardToCount, int award, int delta) {
    awardToCount.put(award, awardToCount.getOrDefault(award, 0) + delta);
    awardToCount.remove(award, 0);
  }
}