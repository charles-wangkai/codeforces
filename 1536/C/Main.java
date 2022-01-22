import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] result = new int[s.length()];
    Map<State, Integer> stateToCount = new HashMap<>();
    int dCount = 0;
    int kCount = 0;
    for (int i = 0; i < result.length; ++i) {
      if (s.charAt(i) == 'D') {
        ++dCount;
      } else {
        ++kCount;
      }

      int g = gcd(dCount, kCount);
      State state = new State(dCount / g, kCount / g);
      stateToCount.put(state, stateToCount.getOrDefault(state, 0) + 1);
      result[i] = stateToCount.get(state);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}

class State {
  int d;
  int k;

  State(int d, int k) {
    this.d = d;
    this.k = k;
  }

  @Override
  public int hashCode() {
    return Objects.hash(d, k);
  }

  @Override
  public boolean equals(Object obj) {
    State other = (State) obj;

    return d == other.d && k == other.k;
  }
}