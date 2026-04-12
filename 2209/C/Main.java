import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      solve(sc, n);
    }

    sc.close();
  }

  static void solve(Scanner sc, int n) {
    Pair[] pairs =
        Stream.concat(
                Stream.of(new Pair(1, 2), new Pair(2, 3), new Pair(3, 1)),
                IntStream.rangeClosed(3, n).mapToObj(i -> new Pair(i * 2 - 1, i * 2)))
            .toArray(Pair[]::new);
    for (Pair pair : pairs) {
      if (query(sc, pair.pos1(), pair.pos2()) == 1) {
        output("! %d".formatted(pair.pos1()));

        return;
      }
    }

    output("! 4");
  }

  static int query(Scanner sc, int pos1, int pos2) {
    output("? %d %d".formatted(pos1, pos2));

    return sc.nextInt();
  }

  static void output(String s) {
    System.out.println(s);
    System.out.flush();
  }
}

record Pair(int pos1, int pos2) {}