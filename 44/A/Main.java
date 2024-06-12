import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] species = new String[n];
    String[] colors = new String[n];
    for (int i = 0; i < n; ++i) {
      species[i] = sc.next();
      colors[i] = sc.next();
    }

    System.out.println(solve(species, colors));

    sc.close();
  }

  static int solve(String[] species, String[] colors) {
    return (int)
        IntStream.range(0, species.length)
            .mapToObj(i -> new Leaf(species[i], colors[i]))
            .distinct()
            .count();
  }
}

record Leaf(String species,String color) {}