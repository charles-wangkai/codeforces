import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[n][n];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int[] lastOneCounts = Arrays.stream(a).mapToInt(Main::countLastOne).sorted().toArray();

    int result = 0;
    int needed = 0;
    for (int lastOneCount : lastOneCounts) {
      if (lastOneCount >= needed) {
        ++needed;
        ++result;
      }
    }

    return result;
  }

  static int countLastOne(int[] line) {
    int index = line.length;
    while (index >= 1 && line[index - 1] == 1) {
      --index;
    }

    return line.length - index;
  }
}