import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int p1 = sc.nextInt();
    int p2 = sc.nextInt();
    int p3 = sc.nextInt();
    int p4 = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(p1, p2, p3, p4, a, b));

    sc.close();
  }

  static int solve(int p1, int p2, int p3, int p4, int a, int b) {
    List<int[]> permutations = new ArrayList<>();
    buildPermutations(permutations, new int[] {p1, p2, p3, p4}, 0);

    return (int)
        IntStream.rangeClosed(a, b)
            .filter(
                x ->
                    permutations.stream()
                            .filter(
                                permutation ->
                                    x
                                            % permutation[0]
                                            % permutation[1]
                                            % permutation[2]
                                            % permutation[3]
                                        == x)
                            .count()
                        >= 7)
            .count();
  }

  static void buildPermutations(List<int[]> permutations, int[] p, int index) {
    if (index == p.length) {
      permutations.add(p.clone());

      return;
    }

    for (int i = index; i < p.length; ++i) {
      swap(p, i, index);
      buildPermutations(permutations, p, index + 1);
      swap(p, i, index);
    }
  }

  static void swap(int[] p, int index1, int index2) {
    int temp = p[index1];
    p[index1] = p[index2];
    p[index2] = temp;
  }
}