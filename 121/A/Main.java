import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int l = sc.nextInt();
    int r = sc.nextInt();

    System.out.println(solve(l, r));

    sc.close();
  }

  static long solve(int l, int r) {
    long result = 0;
    int begin = l;
    String lucky = "4";
    while (true) {
      long value = Long.parseLong(lucky);
      result += value * Math.max(0, Math.min(r, value) - begin + 1);

      if (value >= r) {
        break;
      }

      begin = Math.max(begin, (int) value + 1);
      lucky = buildNextLucky(lucky);
    }

    return result;
  }

  static String buildNextLucky(String lucky) {
    int lastIndex = lucky.lastIndexOf('4');

    return (lastIndex == -1)
        ? "4".repeat(lucky.length() + 1)
        : String.format(
            "%s7%s", lucky.substring(0, lastIndex), "4".repeat(lucky.length() - 1 - lastIndex));
  }
}