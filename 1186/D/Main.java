import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.next();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(String[] a) {
		Real[] reals = Arrays.stream(a).map(Real::new).toArray(Real[]::new);
		long sum = Arrays.stream(reals).mapToLong(Real::floor).sum();

		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++) {
			if (sum < 0) {
				result[i] = reals[i].ceiling();
				sum += reals[i].ceiling() - reals[i].floor();
			} else {
				result[i] = reals[i].floor();
			}
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
	}
}

class Real {
	String integral;
	String decimal;

	Real(String s) {
		String[] fields = s.split("\\.");

		integral = fields[0];
		decimal = fields[1];
	}

	int floor() {
		return Integer.parseInt(integral) + ((integral.startsWith("-") && Integer.parseInt(decimal) != 0) ? -1 : 0);
	}

	int ceiling() {
		return floor() + (Integer.parseInt(decimal) == 0 ? 0 : 1);
	}
}