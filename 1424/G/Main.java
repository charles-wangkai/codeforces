import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] b = new int[n];
    int[] d = new int[n];
    for (int i = 0; i < n; ++i) {
      b[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(b, d));

    sc.close();
  }

  static String solve(int[] b, int[] d) {
    SortedMap<Integer, Integer> yearToDelta = new TreeMap<>();
    for (int i = 0; i < b.length; ++i) {
      yearToDelta.put(b[i], yearToDelta.getOrDefault(b[i], 0) + 1);
      yearToDelta.put(d[i], yearToDelta.getOrDefault(d[i], 0) - 1);
    }

    int maxPeopleNum = -1;
    int bestYear = -1;
    int peopleNum = 0;
    for (int year : yearToDelta.keySet()) {
      peopleNum += yearToDelta.get(year);
      if (peopleNum > maxPeopleNum) {
        maxPeopleNum = peopleNum;
        bestYear = year;
      }
    }

    return "%d %d".formatted(bestYear, maxPeopleNum);
  }
}