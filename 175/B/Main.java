import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] names = new String[n];
    int[] points = new int[n];
    for (int i = 0; i < n; ++i) {
      names[i] = sc.next();
      points[i] = sc.nextInt();
    }

    System.out.println(solve(names, points));

    sc.close();
  }

  static String solve(String[] names, int[] points) {
    Map<String, Integer> nameToMaxPoint = new HashMap<>();
    for (int i = 0; i < names.length; ++i) {
      nameToMaxPoint.put(names[i], Math.max(nameToMaxPoint.getOrDefault(names[i], -1), points[i]));
    }

    return "%d\n%s"
        .formatted(
            nameToMaxPoint.size(),
            nameToMaxPoint.keySet().stream()
                .map(
                    name -> {
                      int lessEqualNum =
                          (int)
                              nameToMaxPoint.values().stream()
                                  .filter(point -> point <= nameToMaxPoint.get(name))
                                  .count();

                      String category;
                      if (lessEqualNum * 100 >= nameToMaxPoint.size() * 99) {
                        category = "pro";
                      } else if (lessEqualNum * 100 >= nameToMaxPoint.size() * 90) {
                        category = "hardcore";
                      } else if (lessEqualNum * 100 >= nameToMaxPoint.size() * 80) {
                        category = "average";
                      } else if (lessEqualNum * 100 >= nameToMaxPoint.size() * 50) {
                        category = "random";
                      } else {
                        category = "noob";
                      }

                      return "%s %s".formatted(name, category);
                    })
                .collect(Collectors.joining("\n")));
  }
}