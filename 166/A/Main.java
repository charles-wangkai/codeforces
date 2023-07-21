import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] p = new int[n];
    int[] t = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = sc.nextInt();
      t[i] = sc.nextInt();
    }
    System.out.println(solve(p, t, k));

    sc.close();
  }

  static int solve(int[] p, int[] t, int k) {
    Team[] sortedTeams =
        IntStream.range(0, p.length)
            .mapToObj(i -> new Team(p[i], t[i]))
            .sorted(Comparator.comparing(Team::p).reversed().thenComparing(Team::t))
            .toArray(Team[]::new);

    int beginIndex = k - 1;
    while (beginIndex >= 1 && sortedTeams[beginIndex - 1].equals(sortedTeams[beginIndex])) {
      beginIndex--;
    }

    int endIndex = k - 1;
    while (endIndex + 1 < sortedTeams.length
        && sortedTeams[endIndex + 1].equals(sortedTeams[endIndex])) {
      endIndex++;
    }

    return endIndex - beginIndex + 1;
  }
}

record Team(int p, int t) {}
