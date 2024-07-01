import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final String[] PROTOCOLS = {"http", "ftp"};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    String protocol = Arrays.stream(PROTOCOLS).filter(s::startsWith).findAny().get();
    int domainEndIndex = s.indexOf("ru", protocol.length() + 1);
    String domain = s.substring(protocol.length(), domainEndIndex);
    String context = s.substring(domainEndIndex + "ru".length());

    return "%s://%s.ru%s".formatted(protocol, domain, context.isEmpty() ? "" : ("/" + context));
  }
}