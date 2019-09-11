import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		String[] commands = new String[n];
		for (int i = 0; i < commands.length; i++) {
			commands[i] = sc.nextLine();
		}
		System.out.print(solve(commands));

		sc.close();
	}

	static String solve(String[] commands) {
		List<String> result = new ArrayList<>();

		List<String> path = new ArrayList<>();
		for (String command : commands) {
			String[] fields = command.split(" ");
			if (fields[0].equals("cd")) {
				if (fields[1].charAt(0) == '/') {
					path.clear();
				}

				for (String name : fields[1].split("/")) {
					if (name.equals("..")) {
						path.remove(path.size() - 1);
					} else if (!name.isEmpty()) {
						path.add(name);
					}
				}
			} else {
				result.add(path.isEmpty() ? "/" : path.stream().collect(Collectors.joining("/", "/", "/")));
			}
		}

		return String.join("\n", result);
	}
}
