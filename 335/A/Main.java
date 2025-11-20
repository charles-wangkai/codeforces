import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int n = sc.nextInt();

    System.out.println(solve(s, n));

    sc.close();
  }

  static String solve(String s, int n) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    if (letterToCount.size() > n) {
      return "-1";
    }

    int sheetNum = findSheetNum(s.length(), n, letterToCount);
    String sheet =
        letterToCount.keySet().stream()
            .map(
                letter ->
                    String.valueOf(letter)
                        .repeat(Math.ceilDiv(letterToCount.get(letter), sheetNum)))
            .collect(Collectors.joining());
    sheet += "a".repeat(Math.max(0, n - sheet.length()));

    return "%d\n%s".formatted(sheetNum, sheet);
  }

  static int findSheetNum(int length, int n, Map<Character, Integer> letterToCount) {
    int result = -1;
    int lower = 1;
    int upper = length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      if (letterToCount.values().stream().mapToInt(count -> Math.ceilDiv(count, middle)).sum()
          <= n) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}