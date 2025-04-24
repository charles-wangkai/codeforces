import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int k = sc.nextInt();
    sc.nextLine();
    String[] rounds = new String[k];
    for (int i = 0; i < rounds.length; ++i) {
      rounds[i] = sc.nextLine();
    }

    System.out.println(solve(x, rounds));

    sc.close();
  }

  static String solve(int x, String[] rounds) {
    boolean[] taken = new boolean[x - 1];
    for (String round : rounds) {
      int[] fields = Arrays.stream(round.split(" ")).mapToInt(Integer::parseInt).toArray();
      taken[fields[1] - 1] = true;
      if (fields[0] == 1) {
        taken[fields[2] - 1] = true;
      }
    }

    return "%d %d".formatted(computeMinSkipNum(taken), computeMaxSkipNum(taken));
  }

  static int computeMinSkipNum(boolean[] taken) {
    int result = 0;
    int count = 0;
    for (int i = 0; i <= taken.length; ++i) {
      if (i != taken.length && !taken[i]) {
        ++count;
      } else {
        result += (count + 1) / 2;
        count = 0;
      }
    }

    return result;
  }

  static int computeMaxSkipNum(boolean[] taken) {
    return (int) IntStream.range(0, taken.length).filter(i -> !taken[i]).count();
  }
}