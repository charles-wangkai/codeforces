import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int e = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, e));
    }

    sc.close();
  }

  static long solve(int[] a, int e) {
    @SuppressWarnings("unchecked")
    List<Integer>[] valueLists = new List[e];
    for (int i = 0; i < valueLists.length; ++i) {
      valueLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      valueLists[i % e].add(a[i]);
    }

    long result = 0;
    for (List<Integer> valueList : valueLists) {
      int[] leftOneCounts = new int[valueList.size()];
      int leftOneCount = 0;
      for (int i = 0; i < leftOneCounts.length; ++i) {
        leftOneCounts[i] = leftOneCount;

        if (valueList.get(i) == 1) {
          ++leftOneCount;
        } else {
          leftOneCount = 0;
        }
      }

      int[] rightOneCounts = new int[valueList.size()];
      int rightOneCount = 0;
      for (int i = rightOneCounts.length - 1; i >= 0; --i) {
        rightOneCounts[i] = rightOneCount;

        if (valueList.get(i) == 1) {
          ++rightOneCount;
        } else {
          rightOneCount = 0;
        }
      }

      for (int i = 0; i < valueList.size(); ++i) {
        if (isPrime(valueList.get(i))) {
          result += (leftOneCounts[i] + 1L) * (rightOneCounts[i] + 1L) - 1;
        }
      }
    }

    return result;
  }

  static boolean isPrime(int x) {
    if (x <= 1) {
      return false;
    }

    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}