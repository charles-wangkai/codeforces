import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int q = sc.nextInt();
    String s = sc.next();
    int[] positions = new int[q];
    char[] c = new char[q];
    for (int i = 0; i < q; ++i) {
      positions[i] = sc.nextInt() - 1;
      c[i] = sc.next().charAt(0);
    }

    System.out.println(solve(s, positions, c));

    sc.close();
  }

  static String solve(String s, int[] positions, char[] c) {
    int[] result = new int[positions.length];
    char[] letters = s.toCharArray();
    int count = (int) IntStream.range(0, s.length()).filter(i -> isMatched(letters, i)).count();
    for (int i = 0; i < result.length; ++i) {
      int i_ = i;
      count -=
          IntStream.rangeClosed(0, 2).filter(j -> isMatched(letters, positions[i_] - j)).count();

      letters[positions[i]] = c[i];
      count +=
          IntStream.rangeClosed(0, 2).filter(j -> isMatched(letters, positions[i_] - j)).count();

      result[i] = count;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static boolean isMatched(char[] letters, int beginIndex) {
    return beginIndex >= 0
        && beginIndex + 2 < letters.length
        && letters[beginIndex] == 'a'
        && letters[beginIndex + 1] == 'b'
        && letters[beginIndex + 2] == 'c';
  }
}