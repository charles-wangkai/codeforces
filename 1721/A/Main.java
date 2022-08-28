import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String[] image = new String[2];
      for (int i = 0; i < image.length; ++i) {
        image[i] = sc.next();
      }

      System.out.println(solve(image));
    }

    sc.close();
  }

  static int solve(String[] image) {
    return (int) String.join("", image).chars().distinct().count() - 1;
  }
}