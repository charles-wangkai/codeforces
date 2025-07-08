import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    String[] a = new String[q];
    String[] b = new String[q];
    for (int i = 0; i < q; ++i) {
      a[i] = sc.next();
      b[i] = sc.next();
    }

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static int solve(int n, String[] a, String[] b) {
    Map<String, String> replaceMap =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> b[i]));

    List<String> strings = new ArrayList<>();
    search(strings, n, "");

    return (int) strings.stream().filter(string -> check(replaceMap, string)).count();
  }

  static boolean check(Map<String, String> replaceMap, String string) {
    while (string.length() != 1) {
      String head = string.substring(0, 2);
      if (!replaceMap.containsKey(head)) {
        return false;
      }

      string = replaceMap.get(head) + string.substring(2);
    }

    return string.equals("a");
  }

  static void search(List<String> strings, int n, String string) {
    if (string.length() == n) {
      strings.add(string);

      return;
    }

    for (char c = 'a'; c <= 'f'; ++c) {
      search(strings, n, string + c);
    }
  }
}