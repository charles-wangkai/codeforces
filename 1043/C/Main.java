import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  static final Comparator<String> FORWARD_COMPARATOR = (s1, s2) -> s1.compareTo(s2);
  static final Comparator<String> BACKWARD_COMPARATOR =
      (s1, s2) -> reverse(s1).compareTo(reverse(s2));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    Element[] candidates = {new Element("", "")};
    for (char c : s.toCharArray()) {
      Element[] elements =
          Arrays.stream(candidates)
              .flatMap(
                  candidate ->
                      Stream.of(
                          new Element(candidate.part() + c, candidate.operations() + '0'),
                          new Element(reverse(candidate.part() + c), candidate.operations() + '1')))
              .toArray(Element[]::new);

      candidates =
          new Element[] {
            findBest(elements, FORWARD_COMPARATOR), findBest(elements, BACKWARD_COMPARATOR)
          };
    }

    return findBest(candidates, FORWARD_COMPARATOR)
        .operations()
        .chars()
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static Element findBest(Element[] candidates, Comparator<String> comparator) {
    Element result = candidates[0];
    for (int i = 1; i < candidates.length; ++i) {
      if (comparator.compare(candidates[i].part(), result.part()) < 0) {
        result = candidates[i];
      }
    }

    return result;
  }

  static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}

record Element(String part, String operations) {}
