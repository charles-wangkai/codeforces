import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static int solve(int[] b) {
    int occupied = 0;
    int half = 0;
    int free = 0;
    for (int bi : b) {
      if (bi == 1) {
        if (free != 0) {
          --free;
        }

        ++half;
      } else if (half != 0) {
        occupied += half / 2;
        free += half / 2;
        half %= 2;

        if (half == 0) {
          --occupied;
          --free;
          half += 2;
        }
      }
    }

    return occupied + half + free;
  }
}
