import static java.util.Map.entry;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  static final Map<Character, Vector> MOVEMENT_TO_OFFSET =
      Map.ofEntries(
          entry('L', new Vector(-1, 0)),
          entry('R', new Vector(1, 0)),
          entry('U', new Vector(0, 1)),
          entry('D', new Vector(0, -1)));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String movements = sc.next();

    System.out.println(solve(movements) ? "OK" : "BUG");

    sc.close();
  }

  static boolean solve(String movements) {
    int x = 0;
    int y = 0;
    Set<Vector> seen = new HashSet<>();
    Vector curr = new Vector(x, y);
    for (char movement : movements.toCharArray()) {
      Vector next =
          new Vector(
              curr.x() + MOVEMENT_TO_OFFSET.get(movement).x(),
              curr.y() + MOVEMENT_TO_OFFSET.get(movement).y());

      if (MOVEMENT_TO_OFFSET.values().stream()
          .anyMatch(
              offset -> seen.contains(new Vector(next.x() + offset.x(), next.y() + offset.y())))) {
        return false;
      }

      seen.add(curr);
      curr = next;
    }

    return true;
  }
}

record Vector(int x, int y) {}
