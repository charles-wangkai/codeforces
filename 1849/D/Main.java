import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int result = 0;
    boolean[] painted = new boolean[a.length];
    for (int i = 0; i < a.length; ++i) {
      if (!painted[i] && a[i] == 2) {
        ++result;
        painted[i] = true;

        for (int offset : new int[] {-1, 1}) {
          int index = i;
          while (true) {
            int nextIndex = index + offset;
            if (!(nextIndex >= 0 && nextIndex < a.length && a[index] != 0)) {
              break;
            }

            --a[index];
            painted[nextIndex] = true;
            index = nextIndex;
          }
        }
      }
    }

    int index = 0;
    while (index != a.length) {
      if (painted[index]) {
        ++index;
      } else if (a[index] == 1) {
        ++result;
        painted[index] = true;

        if (a[index] != 0 && index != a.length - 1 && !painted[index + 1]) {
          while (a[index] != 0 && index != a.length - 1 && !painted[index + 1]) {
            --a[index];
            painted[index + 1] = true;

            ++index;
          }
        } else {
          ++index;
        }
      } else if (index == a.length - 1 || a[index + 1] == 0) {
        ++result;
        painted[index] = true;

        ++index;
      } else {
        int rightIndex = index + 1;
        while (rightIndex != a.length - 1 && a[rightIndex + 1] == 1) {
          ++rightIndex;
        }

        ++result;

        for (int i = index; i <= rightIndex; ++i) {
          a[i] = 0;
          painted[i] = true;
        }

        index = rightIndex + 1;
      }
    }

    return result;
  }
}