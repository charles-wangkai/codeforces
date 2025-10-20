import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder output = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();

      output.append(solve(s)).append("\n");
    }

    System.out.println(output);
  }

  static String solve(String s) {
    for (int mask = 0; mask < 1 << s.length(); ++mask) {
      List<Integer> indices = buildIndices(s, mask);
      if (indices != null) {
        return "%d\n%s"
            .formatted(
                indices.size(),
                indices.stream()
                    .map(index -> index + 1)
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
      }
    }

    return "-1";
  }

  static List<Integer> buildIndices(String s, int mask) {
    List<Integer> indices = new ArrayList<>();
    StringBuilder rest = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      if (((mask >> i) & 1) == 1) {
        if (!indices.isEmpty() && s.charAt(i) == '0' && s.charAt(indices.getLast()) == '1') {
          return null;
        }

        indices.add(i);
      } else {
        rest.append(s.charAt(i));
      }
    }

    return (rest.toString().equals(rest.reverse().toString())) ? indices : null;
  }
}