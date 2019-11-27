import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		sc.nextLine();
		String[] events = new String[q];
		for (int i = 0; i < events.length; i++) {
			events[i] = sc.nextLine();
		}
		System.out.println(solve(a, events));

		sc.close();
	}

	static String solve(int[] a, String[] events) {
		int[] result = new int[a.length];
		Arrays.fill(result, -1);

		int min = 0;
		for (int i = events.length - 1; i >= 0; i--) {
			int[] fields = Arrays.stream(events[i].split(" ")).mapToInt(Integer::parseInt).toArray();

			if (fields[0] == 1) {
				if (result[fields[1] - 1] == -1) {
					result[fields[1] - 1] = Math.max(fields[2], min);
				}
			} else {
				min = Math.max(min, fields[1]);
			}
		}

		for (int i = 0; i < result.length; i++) {
			if (result[i] == -1) {
				result[i] = Math.max(a[i], min);
			}
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
