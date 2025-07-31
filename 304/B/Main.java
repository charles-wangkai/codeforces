import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String date1 = sc.next();
    String date2 = sc.next();

    System.out.println(solve(date1, date2));

    sc.close();
  }

  static int solve(String date1, String date2) {
    return Math.abs((int) ChronoUnit.DAYS.between(toLocalDate(date1), toLocalDate(date2)));
  }

  static LocalDate toLocalDate(String s) {
    return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy:MM:dd"));
  }
}