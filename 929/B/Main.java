import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    char[][] seats = new char[n][12];
    for (int r = 0; r < seats.length; ++r) {
      String line = sc.next();
      for (int c = 0; c < seats[r].length; ++c) {
        seats[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(seats, k));

    sc.close();
  }

  static String solve(char[][] seats, int k) {
    List<Point> points = new ArrayList<>();
    for (int r = 0; r < seats.length; ++r) {
      for (int c = 0; c < seats[r].length; ++c) {
        if (seats[r][c] == '.') {
          points.add(new Point(r, c));
        }
      }
    }
    Collections.sort(
        points, Comparator.comparing(point -> computeAdjSNum(seats, point.r(), point.c())));

    for (int i = 0; i < k; ++i) {
      seats[points.get(i).r()][points.get(i).c()] = 'x';
    }

    int sAdjNum = 0;
    for (int r = 0; r < seats.length; ++r) {
      for (int c = 0; c < seats[r].length; ++c) {
        if (seats[r][c] == 'S') {
          for (int offset : new int[] {-1, 1}) {
            int adjC = c + offset;
            if (adjC >= 0
                && adjC < seats[r].length
                && seats[r][adjC] != '.'
                && seats[r][adjC] != '-') {
              ++sAdjNum;
            }
          }
        }
      }
    }

    return "%d\n%s"
        .formatted(
            sAdjNum, Arrays.stream(seats).map(String::new).collect(Collectors.joining("\n")));
  }

  static int computeAdjSNum(char[][] seats, int r, int c) {
    return (int)
        IntStream.of(-1, 1)
            .filter(
                offset ->
                    c + offset >= 0 && c + offset < seats[r].length && seats[r][c + offset] == 'S')
            .count();
  }
}

record Point(int r, int c) {}
