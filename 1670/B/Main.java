import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      br.readLine();
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      char[] c = new char[k];
      for (int i = 0; i < c.length; ++i) {
        c[i] = st.nextToken().charAt(0);
      }

      System.out.println(solve(s, c));
    }
  }

  static int solve(String s, char[] c) {
    Set<Character> specials =
        IntStream.range(0, c.length).mapToObj(i -> c[i]).collect(Collectors.toSet());

    int result = 0;
    int length = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (specials.contains(s.charAt(i))) {
        result = Math.max(result, length);
        length = 1;
      } else {
        ++length;
      }
    }

    return result;
  }
}