import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int l = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    String[] queries = new String[m];
    sc.nextLine();
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(a, queries, l));

    sc.close();
  }

  static String solve(int[] a, String[] queries, int l) {
    List<Integer> result = new ArrayList<>();
    long[] lengths = Arrays.stream(a).asLongStream().toArray();
    int haircutNum =
        (int)
            IntStream.range(0, lengths.length)
                .filter(i -> lengths[i] > l && (i == 0 || lengths[i - 1] <= l))
                .count();
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("0")) {
        result.add(haircutNum);
      } else {
        int p = Integer.parseInt(fields[1]);
        int d = Integer.parseInt(fields[2]);

        int index = p - 1;
        lengths[index] += d;
        if (lengths[index] > l && lengths[index] - d <= l) {
          if ((index == 0 || lengths[index - 1] <= l)
              && (index == lengths.length - 1 || lengths[index + 1] <= l)) {
            ++haircutNum;
          } else if (index != 0
              && lengths[index - 1] > l
              && index != lengths.length - 1
              && lengths[index + 1] > l) {
            --haircutNum;
          }
        }
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}