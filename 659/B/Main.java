import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    String[] names = new String[n];
    int[] regions = new int[n];
    int[] scores = new int[n];
    for (int i = 0; i < n; ++i) {
      names[i] = sc.next();
      regions[i] = sc.nextInt();
      scores[i] = sc.nextInt();
    }

    System.out.println(solve(names, regions, scores, m));

    sc.close();
  }

  static String solve(String[] names, int[] regions, int[] scores, int m) {
    @SuppressWarnings("unchecked")
    List<Integer>[] memberLists = new List[m];
    for (int i = 0; i < memberLists.length; ++i) {
      memberLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < names.length; ++i) {
      memberLists[regions[i] - 1].add(i);
    }

    for (List<Integer> memberList : memberLists) {
      Collections.sort(
          memberList, Comparator.<Integer, Integer>comparing(member -> scores[member]).reversed());
    }

    return Arrays.stream(memberLists)
        .map(
            memberList ->
                (memberList.size() == 2 || scores[memberList.get(1)] != scores[memberList.get(2)])
                    ? "%s %s".formatted(names[memberList.get(0)], names[memberList.get(1)])
                    : "?")
        .collect(Collectors.joining("\n"));
  }
}