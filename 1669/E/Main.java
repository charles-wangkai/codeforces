import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        st = new StringTokenizer(br.readLine());
        s[i] = st.nextToken();
      }

      System.out.println(solve(s));
    }
  }

  static long solve(String[] s) {
    Map<String, Integer> strToCount = new HashMap<>();
    for (String si : s) {
      strToCount.put(si, strToCount.getOrDefault(si, 0) + 1);
    }

    long result = 0;
    for (String si : s) {
      result += computePairNum(strToCount, si);
    }
    result /= 2;

    return result;
  }

  static int computePairNum(Map<String, Integer> strToCount, String str) {
    int result = 0;
    for (char c = 'a'; c <= 'k'; ++c) {
      if (c != str.charAt(0)) {
        result += strToCount.getOrDefault(String.valueOf(c) + str.charAt(1), 0);
      }
      if (c != str.charAt(1)) {
        result += strToCount.getOrDefault(String.valueOf(str.charAt(0)) + c, 0);
      }
    }

    return result;
  }
}