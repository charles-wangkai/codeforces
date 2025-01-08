import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int DIGIT_NUM = 18;

  static List<Long> classys;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      long L = sc.nextLong();
      long R = sc.nextLong();

      System.out.println(solve(L, R));
    }

    sc.close();
  }

  static void precompute() {
    classys = new ArrayList<>();
    classys.add(1_000_000_000_000_000_000L);

    StringBuilder sb = new StringBuilder("0".repeat(DIGIT_NUM));
    for (int i = 0; i < sb.length(); ++i) {
      for (char di = '1'; di <= '9'; ++di) {
        sb.setCharAt(i, di);

        classys.add(Long.parseLong(sb.toString()));

        sb.setCharAt(i, '0');
      }
    }
    for (int i = 0; i < sb.length(); ++i) {
      for (char di = '1'; di <= '9'; ++di) {
        sb.setCharAt(i, di);

        for (int j = i + 1; j < sb.length(); ++j) {
          for (char dj = '1'; dj <= '9'; ++dj) {
            sb.setCharAt(j, dj);

            classys.add(Long.parseLong(sb.toString()));

            sb.setCharAt(j, '0');
          }
        }

        sb.setCharAt(i, '0');
      }
    }
    for (int i = 0; i < sb.length(); ++i) {
      for (char di = '1'; di <= '9'; ++di) {
        sb.setCharAt(i, di);

        for (int j = i + 1; j < sb.length(); ++j) {
          for (char dj = '1'; dj <= '9'; ++dj) {
            sb.setCharAt(j, dj);

            for (int k = j + 1; k < sb.length(); ++k) {
              for (char dk = '1'; dk <= '9'; ++dk) {
                sb.setCharAt(k, dk);

                classys.add(Long.parseLong(sb.toString()));

                sb.setCharAt(k, '0');
              }
            }

            sb.setCharAt(j, '0');
          }
        }

        sb.setCharAt(i, '0');
      }
    }

    Collections.sort(classys);
  }

  static int solve(long L, long R) {
    int beginIndex = Collections.binarySearch(classys, L);
    if (beginIndex < 0) {
      beginIndex = -beginIndex - 1;
    }

    int endIndex = Collections.binarySearch(classys, R);
    if (endIndex < 0) {
      endIndex = -endIndex - 2;
    }

    return endIndex - beginIndex + 1;
  }
}