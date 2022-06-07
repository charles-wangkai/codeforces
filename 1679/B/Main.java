import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    sc.nextLine();
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }
    System.out.println(solve(a, queries));

    sc.close();
  }

  static String solve(int[] a, String[] queries) {
    long[] result = new long[queries.length];
    Map<Integer, Integer> positionToValue = new HashMap<>();
    int base = -1;
    long sum = 0;
    for (int i = 0; i < a.length; ++i) {
      positionToValue.put(i + 1, a[i]);
      sum += a[i];
    }
    for (int i = 0; i < result.length; ++i) {
      int[] parts = Arrays.stream(queries[i].split(" ")).mapToInt(Integer::parseInt).toArray();
      if (parts[0] == 1) {
        int position = parts[1];
        int value = parts[2];

        sum += value - positionToValue.getOrDefault(position, base);
        positionToValue.put(position, value);
      } else {
        positionToValue = new HashMap<>();
        base = parts[1];
        sum = (long) base * a.length;
      }

      result[i] = sum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}