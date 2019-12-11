import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			String[] p = new String[n];
			for (int i = 0; i < p.length; i++) {
				p[i] = sc.next();
			}

			System.out.println(solve(p));
		}

		sc.close();
	}

	static String solve(String[] p) {
		int changeNum = 0;
		List<String> changedPins = new ArrayList<>();
		Queue<String> queue = new LinkedList<>(Arrays.asList(p));
		while (!queue.isEmpty()) {
			String pin = queue.poll();

			if (changedPins.contains(pin)) {
				for (int i = 0;; i++) {
					String changedPin = String.format("%s%d", pin.subSequence(0, 3), i);

					if (!changedPins.contains(changedPin) && !queue.contains(changedPin)) {
						changedPins.add(changedPin);

						break;
					}
				}

				changeNum++;
			} else {
				changedPins.add(pin);
			}
		}

		return String.format("%d\n%s", changeNum, String.join("\n", changedPins));
	}
}
