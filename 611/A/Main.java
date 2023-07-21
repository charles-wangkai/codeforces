import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    sc.next();
    String unit = sc.next();
    System.out.println(solve(x, unit));

    sc.close();
  }

  static int solve(int x, String unit) {
    int result = 0;
    LocalDate date = LocalDate.of(2016, 1, 1);
    while (date.getYear() == 2016) {
      if (unit.equals("week")) {
        if (date.getDayOfWeek().getValue() == x) {
          result++;
        }
      } else if (unit.equals("month") && date.getDayOfMonth() == x) {
        result++;
      }

      date = date.plusDays(1);
    }
    return result;
  }
}
