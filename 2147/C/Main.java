import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    Set<String> states = Set.of("");
    for (char c : s.toCharArray()) {
      Set<String> nextStates = new HashSet<>();
      for (String state : states) {
        for (char candidate : (c == '1') ? new char[] {'1'} : new char[] {'L', 'R'}) {
          String nextState = state + candidate;
          if (isValid(nextState)) {
            nextStates.add(
                nextState.substring(Math.max(0, nextState.length() - 2), nextState.length()));
          }
        }
      }

      states = nextStates;
    }

    return states.stream().anyMatch(state -> !state.equals("R1"));
  }

  static boolean isValid(String state) {
    return !state.equals("1L")
        && !state.equals("R11")
        && !state.equals("R1R")
        && !state.equals("11L")
        && !state.equals("L1L");
  }
}