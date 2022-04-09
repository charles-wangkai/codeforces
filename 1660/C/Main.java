import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    @SuppressWarnings("unchecked")
    List<Integer>[] indexLists = new List[ALPHABET_SIZE];
    for (int i = 0; i < indexLists.length; ++i) {
      indexLists[i] = new ArrayList<>();
    }

    int[] keepNums = new int[s.length() + 1];
    for (int i = 0; i < s.length(); ++i) {
      keepNums[i + 1] = keepNums[i];

      List<Integer> indexList = indexLists[s.charAt(i) - 'a'];
      indexList.add(i);
      if (indexList.size() >= 2) {
        keepNums[i + 1] =
            Math.max(keepNums[i + 1], keepNums[indexList.get(indexList.size() - 2)] + 2);
      }
    }

    return s.length() - Arrays.stream(keepNums).max().getAsInt();
  }
}