import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[][] a = new int[n][n];
    for (int r = 0; r < n; ++r) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < n; ++c) {
        a[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(a));
  }

  static String solve(int[][] a) {
    int n = a.length;

    Element[][] minExp2Elements = new Element[n][n];
    boolean[][] minExp2FromUps = new boolean[n][n];
    Element[][] minExp5Elements = new Element[n][n];
    boolean[][] minExp5FromUps = new boolean[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (a[r][c] != 0) {
          int exp2 = computeExponent(a[r][c], 2);
          int exp5 = computeExponent(a[r][c], 5);

          if (r == 0 && c == 0) {
            minExp2Elements[r][c] = new Element(exp2, exp5);
          } else if (r != 0
              && minExp2Elements[r - 1][c] != null
              && (c == 0
                  || minExp2Elements[r][c - 1] == null
                  || minExp2Elements[r - 1][c].exp2() < minExp2Elements[r][c - 1].exp2()
                  || (minExp2Elements[r - 1][c].exp2() == minExp2Elements[r][c - 1].exp2()
                      && minExp2Elements[r - 1][c].exp5() < minExp2Elements[r][c - 1].exp5()))) {
            minExp2Elements[r][c] =
                new Element(
                    minExp2Elements[r - 1][c].exp2() + exp2,
                    minExp2Elements[r - 1][c].exp5() + exp5);
            minExp2FromUps[r][c] = true;
          } else if (c != 0 && minExp2Elements[r][c - 1] != null) {
            minExp2Elements[r][c] =
                new Element(
                    minExp2Elements[r][c - 1].exp2() + exp2,
                    minExp2Elements[r][c - 1].exp5() + exp5);
          }

          if (r == 0 && c == 0) {
            minExp5Elements[r][c] = new Element(exp2, exp5);
          } else if (r != 0
              && minExp5Elements[r - 1][c] != null
              && (c == 0
                  || minExp5Elements[r][c - 1] == null
                  || minExp5Elements[r - 1][c].exp5() < minExp5Elements[r][c - 1].exp5()
                  || (minExp5Elements[r - 1][c].exp5() == minExp5Elements[r][c - 1].exp5()
                      && minExp5Elements[r - 1][c].exp2() < minExp5Elements[r][c - 1].exp2()))) {
            minExp5Elements[r][c] =
                new Element(
                    minExp5Elements[r - 1][c].exp2() + exp2,
                    minExp5Elements[r - 1][c].exp5() + exp5);
            minExp5FromUps[r][c] = true;
          } else if (c != 0 && minExp5Elements[r][c - 1] != null) {
            minExp5Elements[r][c] =
                new Element(
                    minExp5Elements[r][c - 1].exp2() + exp2,
                    minExp5Elements[r][c - 1].exp5() + exp5);
          }
        }
      }
    }

    return (getDefaultTrailingZeroNum(minExp2Elements[n - 1][n - 1])
            < getDefaultTrailingZeroNum(minExp5Elements[n - 1][n - 1]))
        ? buildOutput(a, minExp2Elements, minExp2FromUps)
        : buildOutput(a, minExp5Elements, minExp5FromUps);
  }

  static int getDefaultTrailingZeroNum(Element element) {
    return (element == null) ? Integer.MAX_VALUE : element.getTrailingZeroNum();
  }

  static String buildOutput(int[][] a, Element[][] elements, boolean[][] fromUps) {
    int n = elements.length;

    if (elements[n - 1][n - 1] == null || elements[n - 1][n - 1].getTrailingZeroNum() != 0) {
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < n; ++c) {
          if (a[r][c] == 0) {
            return String.format(
                "1\n%s", "D".repeat(r) + "R".repeat(n - 1) + "D".repeat(n - 1 - r));
          }
        }
      }
    }

    StringBuilder reversedPath = new StringBuilder();
    int r = n - 1;
    int c = n - 1;
    while (r != 0 || c != 0) {
      if (fromUps[r][c]) {
        reversedPath.append('D');
        --r;
      } else {
        reversedPath.append('R');
        --c;
      }
    }

    return String.format(
        "%d\n%s", elements[n - 1][n - 1].getTrailingZeroNum(), reversedPath.reverse().toString());
  }

  static int computeExponent(int value, int base) {
    int result = 0;
    while (value % base == 0) {
      value /= base;
      ++result;
    }

    return result;
  }
}

record Element(int exp2, int exp5) {
  int getTrailingZeroNum() {
    return Math.min(exp2, exp5);
  }
}
