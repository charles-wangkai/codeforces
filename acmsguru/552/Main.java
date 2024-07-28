import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    String[][] properties = new String[n][];
    for (int i = 0; i < properties.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      properties[i] = new String[k];
      for (int j = 0; j < properties[i].length; ++j) {
        properties[i][j] = st.nextToken();
      }
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    String[][] queries = new String[m][];
    for (int i = 0; i < queries.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      queries[i] = new String[l];
      for (int j = 0; j < queries[i].length; ++j) {
        queries[i][j] = st.nextToken();
      }
    }

    System.out.println(solve(properties, queries));
  }

  static String solve(String[][] properties, String[][] queries) {
    Map<String, Integer> idToCount = new HashMap<>();
    for (String[] prop : properties) {
      for (int mask = 0; mask < 1 << prop.length; ++mask) {
        String[] parts = new String[Integer.bitCount(mask)];
        int index = 0;
        for (int i = 0; i < prop.length; ++i) {
          if (((mask >> i) & 1) == 1) {
            parts[index] = prop[i];
            ++index;
          }
        }
        String id = generateId(parts);

        idToCount.put(id, idToCount.getOrDefault(id, 0) + 1);
      }
    }

    return Arrays.stream(queries)
        .mapToInt(query -> idToCount.getOrDefault(generateId(query), 0))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static String generateId(String[] parts) {
    Arrays.sort(parts);

    StringBuilder result = new StringBuilder();
    for (String part : parts) {
      if (!result.isEmpty()) {
        result.append(",");
      }
      result.append(part);
    }

    return result.toString();
  }
}