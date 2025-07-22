import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    boolean[] connected = new boolean[s.length()];
    Arrays.fill(connected, true);
    connected[0] = false;
    for (int i = connected.length / 2; i < connected.length; ++i) {
      if (isPrime(i + 1)) {
        connected[i] = false;
      }
    }

    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    if (letterToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt()
        < IntStream.range(0, connected.length).filter(i -> connected[i]).count()) {
      return "NO";
    }

    Character[] sorted =
        s.chars()
            .mapToObj(c -> (char) c)
            .sorted(
                Comparator.<Character, Integer>comparing(letterToCount::get)
                    .reversed()
                    .thenComparing(letter -> letter))
            .toArray(Character[]::new);

    char[] rearranged = new char[s.length()];
    int index = 0;
    for (int i = 0; i < rearranged.length; ++i) {
      if (connected[i]) {
        rearranged[i] = sorted[index];
        ++index;
      }
    }
    for (int i = 0; i < rearranged.length; ++i) {
      if (!connected[i]) {
        rearranged[i] = sorted[index];
        ++index;
      }
    }

    return "YES\n%s".formatted(new String(rearranged));
  }

  static boolean isPrime(int x) {
    if (x < 2) {
      return false;
    }

    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}