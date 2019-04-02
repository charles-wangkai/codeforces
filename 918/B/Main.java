import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<String, String> ipToName = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String ip = sc.next();

			ipToName.put(ip, name);
		}
		sc.nextLine();
		for (int i = 0; i < m; i++) {
			String command = sc.nextLine();

			System.out.println(solve(ipToName, command));
		}

		sc.close();
	}

	static String solve(Map<String, String> ipToName, String command) {
		return String.format("%s #%s", command, ipToName.get(command.split("[ ;]")[1]));
	}
}
