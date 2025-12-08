import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(queries));

    sc.close();
  }

  static String solve(String[] queries) {
    Set<Long> set = new HashSet<>();
    set.add(0L);

    List<Long> result = new ArrayList<>();
    Map<Long, Long> kToMex = new HashMap<>();
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("+")) {
        long x = Long.parseLong(fields[1]);

        set.add(x);
      } else {
        long k = Long.parseLong(fields[1]);

        long mex = kToMex.getOrDefault(k, 0L);
        while (set.contains(mex)) {
          mex += k;
        }

        result.add(mex);
        kToMex.put(k, mex);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}