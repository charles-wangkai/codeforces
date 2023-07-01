import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String A = sc.next();
      String B = sc.next();

      System.out.println(solve(A, B));
    }

    sc.close();
  }

  static int solve(String A, String B) {
    if (IntStream.range(0, A.length()).anyMatch(i -> A.charAt(i) > B.charAt(i))) {
      return -1;
    }

    int result = 0;
    char[] a = A.toCharArray();
    for (char target = 'a'; target <= 't'; ++target) {
      Set<Character> froms = new HashSet<>();
      for (int i = 0; i < a.length; ++i) {
        if (B.charAt(i) == target && a[i] != target) {
          froms.add(a[i]);
        }
      }
      for (int i = 0; i < a.length; ++i) {
        if (a[i] != B.charAt(i) && froms.contains(a[i])) {
          a[i] = target;
        }
      }

      result += froms.size();
    }

    return result;
  }
}
