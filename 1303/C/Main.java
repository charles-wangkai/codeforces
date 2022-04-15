import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[ALPHABET_SIZE];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }
    for (int i = 0; i < s.length() - 1; ++i) {
      int index1 = s.charAt(i) - 'a';
      int index2 = s.charAt(i + 1) - 'a';

      adjSets[index1].add(index2);
      adjSets[index2].add(index1);
    }

    StringBuilder layout =
        new StringBuilder(
            IntStream.range(0, adjSets.length)
                .filter(i -> adjSets[i].isEmpty())
                .mapToObj(i -> String.valueOf((char) (i + 'a')))
                .collect(Collectors.joining()));
    boolean[] visited = new boolean[adjSets.length];
    int[] begins = IntStream.range(0, adjSets.length).filter(i -> adjSets[i].size() == 1).toArray();
    for (int begin : begins) {
      if (!visited[begin]) {
        visited[begin] = true;
        layout.append((char) (begin + 'a'));
        int current = begin;
        while (!adjSets[current].isEmpty()) {
          int next = adjSets[current].iterator().next();
          adjSets[next].remove(current);

          current = next;
          if (visited[current]) {
            return "NO";
          }
          visited[current] = true;
          layout.append((char) (current + 'a'));
        }
      }
    }

    return (layout.length() == ALPHABET_SIZE) ? String.format("YES\n%s", layout) : "NO";
  }
}