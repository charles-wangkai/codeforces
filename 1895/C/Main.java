import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    String[] s = new String[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < s.length; ++i) {
      s[i] = st.nextToken();
    }

    System.out.println(solve(s));
  }

  static long solve(String[] s) {
    Map<State, Integer> stateToCount = new HashMap<>();
    for (String si : s) {
      int prefixSum = 0;
      int suffixSum = si.chars().map(c -> c - '0').sum();
      for (int prefixLength = 0; prefixLength <= si.length(); ++prefixLength) {
        State state = new State(si.length(), prefixLength, prefixSum - suffixSum);
        stateToCount.put(state, stateToCount.getOrDefault(state, 0) + 1);

        if (prefixLength != si.length()) {
          int digit = si.charAt(prefixLength) - '0';
          prefixSum += digit;
          suffixSum -= digit;
        }
      }
    }

    long result = 0;
    for (State leftState : stateToCount.keySet()) {
      for (State rightState : stateToCount.keySet()) {
        if (isLucky(leftState, rightState)) {
          result += (long) stateToCount.get(leftState) * stateToCount.get(rightState);
        }
      }
    }

    return result;
  }

  static boolean isLucky(State leftState, State rightState) {
    return (leftState.length() + rightState.length()) % 2 == 0
        && ((leftState.length() >= rightState.length()
                && rightState.prefixLength() == 0
                && leftState.prefixLength() * 2 == leftState.length() + rightState.length())
            || (leftState.length() < rightState.length()
                && leftState.prefixLength() == leftState.length()
                && (leftState.length() + rightState.prefixLength()) * 2
                    == leftState.length() + rightState.length()))
        && leftState.diff() + rightState.diff() == 0;
  }
}

record State(int length, int prefixLength, int diff) {}
