import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Log[] logs = new Log[n];
		for (int i = 0; i < logs.length; i++) {
			char type = sc.next().charAt(0);
			int registrationNumber = sc.nextInt();

			logs[i] = new Log(type, registrationNumber);
		}
		System.out.println(solve(logs));

		sc.close();
	}

	static int solve(Log[] logs) {
		int beforeCount = 0;
		int delta = 0;
		int maxDelta = 0;
		Set<Integer> entered = new HashSet<>();
		for (Log log : logs) {
			if (log.type == '+') {
				entered.add(log.registrationNumber);

				delta++;
			} else {
				if (entered.contains(log.registrationNumber)) {
					entered.remove(log.registrationNumber);
				} else {
					beforeCount++;
				}

				delta--;
			}

			maxDelta = Math.max(maxDelta, delta);
		}

		return beforeCount + maxDelta;
	}
}

class Log {
	char type;
	int registrationNumber;

	Log(char type, int registrationNumber) {
		this.type = type;
		this.registrationNumber = registrationNumber;
	}
}