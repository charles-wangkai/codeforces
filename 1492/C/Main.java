import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    sc.nextInt();
    String s = sc.next();
    String t = sc.next();

    System.out.println(solve(s, t));

    sc.close();
  }

  static int solve(String s, String t) {
    int[] minIndices = new int[t.length()];
    int minIndex = 0;
    for (int i = 0; i < minIndices.length; ++i) {
      char target = t.charAt(i);
      while (s.charAt(minIndex) != target) {
        ++minIndex;
      }

      minIndices[i] = minIndex;
      ++minIndex;
    }

    int[] maxIndices = new int[t.length()];
    int maxIndex = s.length() - 1;
    for (int i = maxIndices.length - 1; i >= 0; --i) {
      char target = t.charAt(i);
      while (s.charAt(maxIndex) != target) {
        --maxIndex;
      }

      maxIndices[i] = maxIndex;
      --maxIndex;
    }

    return IntStream.range(0, t.length() - 1)
        .map(i -> maxIndices[i + 1] - minIndices[i])
        .max()
        .getAsInt();
  }
}
