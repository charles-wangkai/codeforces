import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_003;
  static final Map<Character, String> COMMAND_TO_CODE =
      Map.ofEntries(
          entry('>', "1000"),
          entry('<', "1001"),
          entry('+', "1010"),
          entry('-', "1011"),
          entry('.', "1100"),
          entry(',', "1101"),
          entry('[', "1110"),
          entry(']', "1111"));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String p = sc.next();

    System.out.println(solve(p));

    sc.close();
  }

  static int solve(String p) {
    int result = 0;
    for (char command : p.toCharArray()) {
      for (char c : COMMAND_TO_CODE.get(command).toCharArray()) {
        result = addMod(multiplyMod(result, 2), c - '0');
      }
    }

    return result;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}