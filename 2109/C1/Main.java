import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      send(sc, "digit");
      send(sc, "digit");
      send(sc, "add -8");
      send(sc, "add -4");
      send(sc, "add -2");
      send(sc, "add -1");
      send(sc, "add %d".formatted(n - 1));
      send(sc, "!");
    }

    sc.close();
  }

  static int send(Scanner sc, String command) {
    System.out.println(command);
    System.out.flush();

    return sc.nextInt();
  }
}