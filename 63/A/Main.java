import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Map<String, Integer> statusToPriority = new HashMap<>();
	static {
		statusToPriority.put("rat", 0);
		statusToPriority.put("woman", 1);
		statusToPriority.put("child", 1);
		statusToPriority.put("man", 2);
		statusToPriority.put("captain", 3);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Member[] members = new Member[n];
		for (int i = 0; i < members.length; i++) {
			String name = sc.next();
			String status = sc.next();

			members[i] = new Member(name, status);
		}
		System.out.print(solve(members));

		sc.close();
	}

	static String solve(Member[] members) {
		return Arrays.stream(members)
				.sorted((member1, member2) -> Integer.compare(statusToPriority.get(member1.status),
						statusToPriority.get(member2.status)))
				.map(member -> member.name).collect(Collectors.joining("\n"));
	}
}

class Member {
	String name;
	String status;

	Member(String name, String status) {
		this.name = name;
		this.status = status;
	}
}