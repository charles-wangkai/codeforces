import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    Set<String> words1 = readSet(sc, n);
    Set<String> words2 = readSet(sc, m);
    System.out.println(solve(words1, words2) ? "YES" : "NO");

    sc.close();
  }

  static Set<String> readSet(Scanner sc, int size) {
    Set<String> result = new HashSet<>();
    for (int i = 0; i < size; i++) {
      result.add(sc.next());
    }

    return result;
  }

  static boolean solve(Set<String> words1, Set<String> words2) {
    int bothCount = (int) words1.stream().filter(words2::contains).count();
    int onlyCount1 = words1.size() - bothCount;
    int onlyCount2 = words2.size() - bothCount;

    return onlyCount1 + bothCount % 2 > onlyCount2;
  }
}
