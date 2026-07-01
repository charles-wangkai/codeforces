import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int[] zeroIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '0').toArray();
    int[] oneIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '1').toArray();

    return (zeroIndices.length != 0
            && oneIndices.length != 0
            && (zeroIndices[zeroIndices.length - 1] < oneIndices[0]
                || oneIndices[oneIndices.length - 1] < zeroIndices[0]))
        ? 2
        : 1;
  }
}