import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static long solve(String s) {
    @SuppressWarnings("unchecked")
    List<Integer>[] indexLists = new List[ALPHABET_SIZE];
    for (int i = 0; i < indexLists.length; ++i) {
      indexLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < s.length(); ++i) {
      indexLists[s.charAt(i) - 'a'].add(i);
    }

    long result = Arrays.stream(indexLists).mapToInt(List::size).max().getAsInt();
    for (int i = 0; i < indexLists.length; ++i) {
      for (int j = 0; j < indexLists.length; ++j) {
        result = Math.max(result, computePairNum(indexLists[i], indexLists[j]));
      }
    }

    return result;
  }

  static long computePairNum(List<Integer> indices1, List<Integer> indices2) {
    long result = 0;
    int pos2 = 0;
    for (int index1 : indices1) {
      while (pos2 != indices2.size() && indices2.get(pos2) <= index1) {
        ++pos2;
      }

      result += indices2.size() - pos2;
    }

    return result;
  }
}