import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String[] moves = new String[n];
      for (int i = 0; i < moves.length; ++i) {
        sc.nextInt();
        moves[i] = sc.next();
      }

      System.out.println(solve(a, moves));
    }

    sc.close();
  }

  static String solve(int[] a, String[] moves) {
    int[] result = a.clone();
    for (int i = 0; i < result.length; ++i) {
      for (char move : moves[i].toCharArray()) {
        if (move == 'U') {
          result[i] = Math.floorMod(result[i] - 1, 10);
        } else {
          result[i] = Math.floorMod(result[i] + 1, 10);
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}