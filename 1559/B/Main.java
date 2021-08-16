import java.util.Scanner;

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

  static String solve(String s) {
    char[] colors = s.toCharArray();
    if (s.chars().allMatch(ch -> ch == '?')) {
      for (int i = 0; i < colors.length; ++i) {
        colors[i] = (i % 2 == 0) ? 'B' : 'R';
      }
    } else {
      while (true) {
        boolean changed = false;
        for (int i = 0; i < colors.length; ++i) {
          if (colors[i] == '?') {
            if ((i != 0 && colors[i - 1] == 'R')
                || (i != colors.length - 1 && colors[i + 1] == 'R')) {
              colors[i] = 'B';

              changed = true;
            } else if ((i != 0 && colors[i - 1] == 'B')
                || (i != colors.length - 1 && colors[i + 1] == 'B')) {
              colors[i] = 'R';

              changed = true;
            }
          }
        }

        if (!changed) {
          break;
        }
      }
    }

    return new String(colors);
  }
}
