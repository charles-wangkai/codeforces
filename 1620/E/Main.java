import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = br.readLine();
    }

    System.out.println(solve(queries));
  }

  static String solve(String[] queries) {
    int size = 0;
    Map<Integer, List<Object>> valueToIndices = new HashMap<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int x = fields[1];

        valueToIndices.putIfAbsent(x, new ArrayList<>());
        valueToIndices.get(x).add(size);
        ++size;
      } else {
        int x = fields[1];
        int y = fields[2];
        if (y != x && valueToIndices.containsKey(x)) {
          valueToIndices.putIfAbsent(y, new ArrayList<>());
          valueToIndices.get(y).add(valueToIndices.get(x));
          valueToIndices.remove(x);
        }
      }
    }

    int[] array = new int[size];
    for (int value : valueToIndices.keySet()) {
      fill(array, value, valueToIndices.get(value));
    }

    return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void fill(int[] array, int value, Object obj) {
    if (obj instanceof List list) {
      for (Object o : list) {
        fill(array, value, o);
      }
    } else {
      array[(int) obj] = value;
    }
  }
}