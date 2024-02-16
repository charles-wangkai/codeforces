import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(String s) {
    int[] sortedIndices =
        IntStream.range(0, s.length())
            .boxed()
            .sorted(Comparator.comparing(s::charAt).reversed().thenComparing(i -> i))
            .mapToInt(Integer::intValue)
            .toArray();

    List<Integer> chosenIndices = new ArrayList<>();
    int lastIndex = -1;
    for (int index : sortedIndices) {
      if (index > lastIndex) {
        chosenIndices.add(index);
        lastIndex = index;
      }
    }

    char[] letters = s.toCharArray();
    for (int i = 0, j = chosenIndices.size() - 1; i < j; ++i, --j) {
      char temp = letters[chosenIndices.get(i)];
      letters[chosenIndices.get(i)] = letters[chosenIndices.get(j)];
      letters[chosenIndices.get(j)] = temp;
    }

    return IntStream.range(0, letters.length - 1).allMatch(i -> letters[i] <= letters[i + 1])
        ? (int)
            chosenIndices.stream()
                .filter(chosenIndex -> s.charAt(chosenIndex) != s.charAt(chosenIndices.get(0)))
                .count()
        : -1;
  }
}