import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int x) {
    String binary = Integer.toBinaryString(x);
    if (binary.endsWith("1") || binary.contains("11")) {
      return "-1";
    }

    StringBuilder aBinary = new StringBuilder();
    StringBuilder bBinary = new StringBuilder();
    for (int i = 0; i < binary.length(); ++i) {
      if (binary.charAt(i) == '1') {
        aBinary.append(0);
        bBinary.append(1);
      } else if (i != 0 && binary.charAt(i - 1) == '1') {
        aBinary.append(1);
        bBinary.append(1);
      } else {
        aBinary.append(0);
        bBinary.append(0);
      }
    }

    return String.format(
        "%d %d", Integer.parseInt(aBinary.toString(), 2), Integer.parseInt(bBinary.toString(), 2));
  }
}
