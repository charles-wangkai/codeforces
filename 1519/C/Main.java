import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n];
      for (int i = 0; i < u.length; ++i) {
        u[i] = sc.nextInt();
      }
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(u, s));
    }

    sc.close();
  }

  static String solve(int[] u, int[] s) {
    int n = u.length;

    Map<Integer, List<Integer>> universityToSkills = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      if (!universityToSkills.containsKey(u[i])) {
        universityToSkills.put(u[i], new ArrayList<>());
      }

      universityToSkills.get(u[i]).add(s[i]);
    }

    long[] result = new long[n];
    for (List<Integer> skills : universityToSkills.values()) {
      Collections.sort(skills, Comparator.reverseOrder());

      long[] prefixSums = new long[skills.size() + 1];
      for (int i = 1; i < prefixSums.length; ++i) {
        prefixSums[i] = prefixSums[i - 1] + skills.get(i - 1);
      }

      for (int i = 1; i <= skills.size(); ++i) {
        result[i - 1] += prefixSums[skills.size() / i * i];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
