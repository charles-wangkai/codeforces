import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String events = sc.next();
		System.out.println(solve(events));

		sc.close();
	}

	static String solve(String events) {
		boolean[] occupied = new boolean[10];
		for (char event : events.toCharArray()) {
			if (event == 'L') {
				for (int i = 0;; i++) {
					if (!occupied[i]) {
						occupied[i] = true;
						break;
					}
				}
			} else if (event == 'R') {
				for (int i = occupied.length - 1;; i--) {
					if (!occupied[i]) {
						occupied[i] = true;
						break;
					}
				}
			} else {
				occupied[event - '0'] = false;
			}
		}

		return IntStream.range(0, occupied.length).mapToObj(i -> occupied[i] ? "1" : "0").collect(Collectors.joining());
	}
}
