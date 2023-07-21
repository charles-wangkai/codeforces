import java.util.Scanner;

public class Main {
  static final int[] GOOD_NUMS = {2, 7, 2, 3, 3, 4, 2, 5, 1, 2};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String n = sc.next();
    System.out.println(solve(n));

    sc.close();
  }

  static int solve(String n) {
    return n.chars()
        .map(ch -> GOOD_NUMS[ch - '0'])
        .reduce(1, (result, element) -> result * element);
  }
}
