import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }
    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String[] s) {
    Map<Character, Character> letterToParent = new HashMap<>();
    for (String si : s) {
      for (char letter : si.toCharArray()) {
        if (!letterToParent.containsKey(letter)) {
          letterToParent.put(letter, null);
        }
      }
    }

    for (String si : s) {
      for (int i = 0; i < si.length() - 1; ++i) {
        char root1 = findRoot(letterToParent, si.charAt(i));
        char root2 = findRoot(letterToParent, si.charAt(i + 1));

        if (root1 != root2) {
          letterToParent.put(root2, root1);
        }
      }
    }

    return (int) letterToParent.values().stream().filter(Objects::isNull).count();
  }

  static char findRoot(Map<Character, Character> letterToParent, char letter) {
    char root = letter;
    while (letterToParent.get(root) != null) {
      root = letterToParent.get(root);
    }

    char p = letter;
    while (p != root) {
      char next = letterToParent.get(p);
      letterToParent.put(p, root);

      p = next;
    }

    return root;
  }
}
