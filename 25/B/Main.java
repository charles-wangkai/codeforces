import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String phone = sc.next();

    System.out.println(solve(phone));

    sc.close();
  }

  static String solve(String phone) {
    List<String> groups = new ArrayList<>();
    int index = 0;
    while (index != phone.length()) {
      String group =
          phone.substring(index, (phone.length() - index <= 3) ? phone.length() : (index + 2));
      groups.add(group);
      index += group.length();
    }

    return String.join("-", groups);
  }
}