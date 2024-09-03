import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] beatmap = new char[n][];
      for (int r = 0; r < beatmap.length; ++r) {
        beatmap[r] = sc.next().toCharArray();
      }

      System.out.println(solve(beatmap));
    }

    sc.close();
  }

  static String solve(char[][] beatmap) {
    return IntStream.range(0, beatmap.length)
        .map(
            i ->
                IntStream.range(0, beatmap[beatmap.length - 1 - i].length)
                        .filter(c -> beatmap[beatmap.length - 1 - i][c] == '#')
                        .findAny()
                        .getAsInt()
                    + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}