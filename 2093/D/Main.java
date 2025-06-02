import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      sc.nextLine();
      String[] questions = new String[q];
      for (int i = 0; i < questions.length; ++i) {
        questions[i] = sc.nextLine();
      }

      System.out.println(solve(n, questions));
    }

    sc.close();
  }

  static String solve(int n, String[] questions) {
    return Arrays.stream(questions)
        .map(
            question -> {
              String[] fields = question.split(" ");
              if (fields[0].equals("->")) {
                int x = Integer.parseInt(fields[1]);
                int y = Integer.parseInt(fields[2]);

                return "%d".formatted(computeValue(1 << n, x - 1, y - 1) + 1);
              } else {
                long d = Long.parseLong(fields[1]);

                Point point = find(1 << n, d - 1);

                return "%d %d".formatted(point.r() + 1, point.c() + 1);
              }
            })
        .collect(Collectors.joining("\n"));
  }

  static long computeValue(int side, int r, int c) {
    if (side == 1) {
      return 0;
    }

    int nextSide = side / 2;
    long quarter = (long) nextSide * nextSide;

    if (r < nextSide) {
      if (c < nextSide) {
        return computeValue(nextSide, r, c);
      }

      return quarter * 3 + computeValue(nextSide, r, c - nextSide);
    }

    if (c < nextSide) {
      return quarter * 2 + computeValue(nextSide, r - nextSide, c);
    }

    return quarter + computeValue(nextSide, r - nextSide, c - nextSide);
  }

  static Point find(int side, long value) {
    if (side == 1) {
      return new Point(0, 0);
    }

    int nextSide = side / 2;
    long quarter = (long) nextSide * nextSide;

    if (value < quarter) {
      return find(nextSide, value);
    }
    if (value < quarter * 2) {
      return translate(find(nextSide, value - quarter), nextSide, nextSide);
    }
    if (value < quarter * 3) {
      return translate(find(nextSide, value - quarter * 2), nextSide, 0);
    }

    return translate(find(nextSide, value - quarter * 3), 0, nextSide);
  }

  static Point translate(Point point, int dr, int dc) {
    return new Point(point.r() + dr, point.c() + dc);
  }
}

record Point(int r, int c) {}
