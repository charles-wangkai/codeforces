import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] dances = new int[m][3];
    for (int i = 0; i < dances.length; ++i) {
      for (int j = 0; j < dances[i].length; ++j) {
        dances[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(n, dances));

    sc.close();
  }

  static String solve(int n, int[][] dances) {
    Map<Integer, Integer> dancerToColor = new HashMap<>();
    for (int[] dance : dances) {
      if (dancerToColor.containsKey(dance[0])) {
        update(dancerToColor, dance[0], dance[1], dance[2]);
      } else if (dancerToColor.containsKey(dance[1])) {
        update(dancerToColor, dance[1], dance[2], dance[0]);
      } else {
        update(dancerToColor, dance[2], dance[0], dance[1]);
      }
    }

    return IntStream.rangeClosed(1, n)
        .map(dancerToColor::get)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static void update(Map<Integer, Integer> dancerToColor, int dancer1, int dancer2, int dancer3) {
    if (dancerToColor.containsKey(dancer1)) {
      int color1 = dancerToColor.get(dancer1);
      if (color1 == 1) {
        dancerToColor.put(dancer2, 2);
        dancerToColor.put(dancer3, 3);
      } else if (color1 == 2) {
        dancerToColor.put(dancer2, 3);
        dancerToColor.put(dancer3, 1);
      } else {
        dancerToColor.put(dancer2, 1);
        dancerToColor.put(dancer3, 2);
      }
    } else {
      dancerToColor.put(dancer1, 1);
      dancerToColor.put(dancer2, 2);
      dancerToColor.put(dancer3, 3);
    }
  }
}