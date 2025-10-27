import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String[] records = new String[n];
    for (int i = 0; i < records.length; ++i) {
      records[i] = sc.nextLine();
    }

    System.out.println(solve(records));

    sc.close();
  }

  static String solve(String[] records) {
    Map<String, Set<String>> nameToPhoneNumberSet = new HashMap<>();
    for (String record : records) {
      String[] fields = record.split(" ");
      String name = fields[0];
      nameToPhoneNumberSet.putIfAbsent(name, new HashSet<>());
      for (int i = 2; i < fields.length; ++i) {
        nameToPhoneNumberSet.get(name).add(fields[i]);
      }
    }

    Map<String, List<String>> nameToPhoneNumberList =
        nameToPhoneNumberSet.keySet().stream()
            .collect(
                Collectors.toMap(
                    name -> name,
                    name ->
                        nameToPhoneNumberSet.get(name).stream()
                            .filter(
                                phoneNumber ->
                                    !nameToPhoneNumberSet.get(name).stream()
                                        .anyMatch(
                                            p -> !p.equals(phoneNumber) && p.endsWith(phoneNumber)))
                            .toList()));

    return "%d\n%s"
        .formatted(
            nameToPhoneNumberList.size(),
            nameToPhoneNumberList.keySet().stream()
                .map(
                    name ->
                        "%s %d %s"
                            .formatted(
                                name,
                                nameToPhoneNumberList.get(name).size(),
                                String.join(" ", nameToPhoneNumberList.get(name))))
                .collect(Collectors.joining("\n")));
  }
}