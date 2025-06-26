import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  static final int BIT_NUM = 17;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int sum = sc.nextInt();
    int limit = sc.nextInt();

    System.out.println(solve(sum, limit));

    sc.close();
  }

  static String solve(int sum, int limit) {
    @SuppressWarnings("unchecked")
    List<List<Integer>>[] valueLists = new List[BIT_NUM];
    for (int i = 0; i < valueLists.length; ++i) {
      valueLists[i] = new ArrayList<>();
    }
    for (int i = 1; i <= limit; ++i) {
      valueLists[Integer.numberOfTrailingZeros(i)].add(List.of(i));
    }

    List<Integer> set = new ArrayList<>();
    for (int b = 0; b < BIT_NUM; ++b) {
      if (((sum >> b) & 1) != 0) {
        if (valueLists[b].isEmpty()) {
          return "-1";
        }

        set.addAll(valueLists[b].removeLast());
      }

      if (b != valueLists.length - 1) {
        for (int i = 0; i + 1 < valueLists[b].size(); i += 2) {
          valueLists[b + 1].add(
              Stream.concat(valueLists[b].get(i).stream(), valueLists[b].get(i + 1).stream())
                  .toList());
        }
      }
    }

    return "%d\n%s"
        .formatted(set.size(), set.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}