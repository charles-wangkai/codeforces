import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String S, String T) {
    Map<Character, Integer> sLetterToIndex = new HashMap<>();
    for (int i = 1; i < S.length(); ++i) {
      if (!sLetterToIndex.containsKey(S.charAt(i))) {
        sLetterToIndex.put(S.charAt(i), i);
      }
    }

    Map<Character, Integer> tLetterToIndex = new HashMap<>();
    for (int i = T.length() - 2; i >= 0; --i) {
      if (!tLetterToIndex.containsKey(T.charAt(i))) {
        tLetterToIndex.put(T.charAt(i), i);
      }
    }

    int leftLength = -1;
    int rigthLength = -1;
    for (char letter = 'a'; letter <= 'z'; ++letter) {
      if (sLetterToIndex.containsKey(letter) && tLetterToIndex.containsKey(letter)) {
        int left = sLetterToIndex.get(letter) + 1;
        int right = T.length() - tLetterToIndex.get(letter);
        if (leftLength == -1 || left + right < leftLength + rigthLength) {
          leftLength = left;
          rigthLength = right;
        }
      }
    }

    return (leftLength == -1)
        ? "-1"
        : (S.substring(0, leftLength) + T.substring(T.length() - rigthLength + 1));
  }
}