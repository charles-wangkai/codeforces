import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  static final Map<String, List<String>> BASE_TO_PERMUTATIONS =
      Stream.of("12", "123", "1234")
          .collect(Collectors.toMap(base -> base, Main::buildPermutations));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String n = sc.next();
      int j = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, j, k));
    }

    sc.close();
  }

  static List<String> buildPermutations(String base) {
    List<String> permutations = new ArrayList<>();
    search(permutations, base.toCharArray(), 0);
    Collections.sort(permutations);

    return permutations;
  }

  static void search(List<String> permutations, char[] digits, int index) {
    if (index == digits.length) {
      permutations.add(String.valueOf(digits));

      return;
    }

    for (int i = index; i < digits.length; ++i) {
      swap(digits, i, index);
      search(permutations, digits, index + 1);
      swap(digits, i, index);
    }
  }

  static void swap(char[] a, int index1, int index2) {
    char temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static String solve(String n, int j, int k) {
    int x =
        (int)
            IntStream.range(0, n.length())
                .filter(
                    i ->
                        BASE_TO_PERMUTATIONS.get(n).get(j - 1).charAt(i)
                            == BASE_TO_PERMUTATIONS.get(n).get(k - 1).charAt(i))
                .count();
    int y = n.length() - x;

    return "%dA%dB".formatted(x, y);
  }
}